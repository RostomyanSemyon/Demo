package com.jcourse.rostomyan;

import java.util.Stack;

/**
 * Created by Semyon Rostomyan on 30.11.2017.
 */
public class Division implements Command {
    @MyAnnotation(argtype = ArgType.STACK)
    private Stack<Double> stack;

    public void execute(){
        try{
            double a = stack.pop();
            double b = stack.pop();
            if(b == 0){
                System.out.println("Please don't devide by zero!");
            }
            else {
                stack.push(a/b);
            }
        }
        catch (Exception ex){
            System.out.println("Stack doesn't contain 2 elements");
        }
    }

}
