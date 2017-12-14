package demo;

import java.util.Stack;

/**
 * Created by Semyon Rostomyan on 30.11.2017.
 */
public class Subtraction implements Command {
    @MyAnnotation(argtype = ArgType.STACK)
    private Stack<Double> stack;

    public void execute(){
        try{
            double a = stack.pop();
            double b = stack.pop();
            stack.push(a-b);
        }
        catch (Exception ex){
            System.out.println("Stack doesn't contain 2 elements");
        }
    }
}
