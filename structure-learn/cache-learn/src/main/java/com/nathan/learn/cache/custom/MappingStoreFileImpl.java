package com.nathan.learn.cache.custom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class MappingStoreFileImpl extends MappingStoreSerializableImpl {
    private static final Logger LOG = LoggerFactory.getLogger(MappingStoreFileImpl.class);
    private static final String HIVE_KEY_MAPPING_STORE_DIR = "hive.jd.mapping.store.dir";
    /**
     * Store file for the mapping.
     */
    private File rootFile;

    @Override
    public boolean initDriver() {
        if (this.rootFile == null) {
            String dir = getConf().get(HIVE_KEY_MAPPING_STORE_DIR, System.getenv("HIVE_CONF_DIR"));
            File dirFile = new File(dir);
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }
            this.rootFile = new File(dirFile, getIdentifier());
        }
        setInitialized(true);
        return true;
    }

    @Override
    public <T> Map<String, T> getAll(Class<T> clazz) {
        Map<String, T> rst = null;
        if (rootFile.exists()) {
            try {
                byte[] bytes = Files.readAllBytes(Paths.get(rootFile.toURI()));
                rst = deserialize(new String(bytes, StandardCharsets.UTF_8));
            } catch (Exception ex) {
                LOG.error("Cannot open read stream for record " + rootFile.getName(), ex);
            }
        }
        return rst;
    }

    @Override
    public <T> boolean putAll(Map<String, T> records) {
        try {
            String data = serialize(records);
            Files.write(rootFile.toPath(), data.getBytes());
        } catch (IOException e) {
            LOG.error("Write mapping store file error", e);
        }
        return true;
    }

    @Override
    public String getType() {
        return "file";
    }
}
