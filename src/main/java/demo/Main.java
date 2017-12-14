package demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import org.apache.log4j.Logger;

/**
 * Created by Semyon Rostomyan on 08.12.2017.
 */
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {

        Stack<Double> stack = new Stack<>();
        Map<String, Double> variableMap = new HashMap<>();
        //InputStream in = Main.class.getClassLoader().getResourceAsStream("com.jcourse.rostomyan\\commands");
        InputStream in = Main.class.getClassLoader().getResourceAsStream("commands");
        Properties properties = new Properties();
        properties.load(in);
        Factory factory = new Factory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("start typing..");
        while (scanner.hasNextLine()) {
            logger.info("Start ops");
            logger.error("error");
            String[] command = factory.readCommand(scanner.nextLine());
            factory.createCommand(stack, variableMap, command, properties).execute();
        }
    }
}
