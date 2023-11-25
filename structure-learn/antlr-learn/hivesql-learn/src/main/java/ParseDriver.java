import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.UnbufferedCharStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.StringReader;

public class ParseDriver {
    public static void parse(String command){
        HiveLexer hiveLexer = new HiveLexer(new ANTLRInputStream(command));
        HiveParser hiveParser = new HiveParser(new BufferedTokenStream(hiveLexer));
        ParseTree result = hiveParser.expression();
        System.out.println(result.toStringTree(hiveParser));
    }

    public static void main(String[] args) {
        parse("1+23");
    }
}
