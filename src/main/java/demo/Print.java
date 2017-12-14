package demo;

import java.util.Map;
import java.util.Stack;

/**
 * Created by Semyon Rostomyan on 30.11.2017.
 */
public class Print implements Command {
    @MyAnnotation(argtype = ArgType.STACK)
    private Stack<Double> stack;
    @MyAnnotation(argtype = ArgType.DEFINITIONS)
    private Map<String, Double> varMap;
    @MyAnnotation(argtype = ArgType.CONTEXT)
    private String[] arguments;
    public void execute()
    {
        try {
            System.out.println(stack.peek());
        } catch (Exception ex) {
            System.out.println("Stack is empty");
        }
    }
}
