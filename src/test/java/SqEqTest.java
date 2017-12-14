
import demo.Factory;
import org.junit.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

/**
 * Created by Semyon Rostomyan on 02.12.2017.
 */

public class SqEqTest {
    @Test
    public void testGetRoots() throws Exception {

        Factory testFactory = new Factory();
        Stack<Double> stack = new Stack<>();
        Map<String, Double> variableMap = new HashMap<>();
        InputStream in = SqEqTest.class.getClassLoader().getResourceAsStream("commands");
        Properties properties = new Properties();
        properties.load(in);
        Scanner scanner = new Scanner(new FileInputStream("C:\\Demo\\src\\test\\java\\input.txt"));
        while (scanner.hasNextLine()) {
            String[] str = scanner.nextLine().split(" ");
            testFactory.createCommand(stack, variableMap, str, properties).execute();
        }
        double result = stack.peek();
        Assert.assertEquals(1.0, result, 0.0);
    }
}

