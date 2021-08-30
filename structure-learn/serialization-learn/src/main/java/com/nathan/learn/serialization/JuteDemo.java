package com.nathan.learn.serialization;

import com.esotericsoftware.kryo.io.ByteBufferInputStream;
import org.apache.jute.BinaryInputArchive;
import org.apache.jute.BinaryOutputArchive;
import org.apache.jute.InputArchive;
import org.apache.jute.OutputArchive;
import org.apache.jute.Record;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class JuteDemo {

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BinaryOutputArchive boa = BinaryOutputArchive.getArchive(baos);
        new MockReHeader(0x3421eccb92a34eL, "ping").serialize(boa, "header");

        ByteBuffer bb = ByteBuffer.wrap(baos.toByteArray());

        ByteBufferInputStream bbis = new ByteBufferInputStream(bb);
        BinaryInputArchive bia = BinaryInputArchive.getArchive(bbis);

        MockReHeader header2 = new MockReHeader();
        System.out.println(header2);
        header2.deserialize(bia, "header");
        System.out.println(header2);
        bbis.close();
        baos.close();
    }


    public static class MockReHeader implements Record {
        private long sessionId;
        private String type;

        public MockReHeader() {

        }

        public MockReHeader(long sessionId, String type) {
            this.sessionId = sessionId;
            this.type = type;
        }

        public void setSessionId(long sessionId) {
            this.sessionId = sessionId;
        }

        public void setType(String type) {
            this.type = type;
        }

        public long getSessionId() {
            return sessionId;
        }

        public String getType() {
            return type;
        }

        @Override
        public void serialize(OutputArchive oa, String tag) throws java.io.IOException {
            oa.startRecord(this, tag);
            oa.writeLong(sessionId, "sessionId");
            oa.writeString(type, "type");
            oa.endRecord(this, tag);
        }

        @Override
        public void deserialize(InputArchive ia, String tag) throws java.io.IOException {
            ia.startRecord(tag);
            this.sessionId = ia.readLong("sessionId");
            this.type = ia.readString("type");
            ia.endRecord(tag);
        }

        @Override
        public String toString() {
            return "sessionId = " + sessionId + ", type = " + type;
        }
    }
}
