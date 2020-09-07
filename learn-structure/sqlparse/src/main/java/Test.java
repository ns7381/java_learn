import org.snt.inmemantlr.GenericParser;
import org.snt.inmemantlr.exceptions.IllegalWorkflowException;
import org.snt.inmemantlr.exceptions.ParsingException;

import java.io.File;
import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException, IllegalWorkflowException, ParsingException {
        File[] files = {
                new File("MySQLLexer.g4"),
                new File("MySQLParser.g4")
        };
        // simply pass files to constructor
        GenericParser gp = new GenericParser(files);
        System.out.println(gp.parse("select * from user"));
    }
}
