package demo;

import java.util.Stack;

/**
 * Created by Semyon Rostomyan on 30.11.2017.
 */
public class Exp implements Command {
    @MyAnnotation(argtype = ArgType.STACK)
    private Stack<Double> stack;

    public void execute(){
        try{
            double a = stack.pop();
            a = Math.exp(a);
            stack.push(a);
        }
        catch (Exception ex){
            System.out.println("Stack is empty");
        }
    }
}
