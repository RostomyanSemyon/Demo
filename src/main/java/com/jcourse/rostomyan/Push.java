package com.jcourse.rostomyan;

import java.util.*;

/**
 * Created by Semyon Rostomyan on 30.11.2017.
 */
public class Push implements Command {

    @MyAnnotation(argtype = ArgType.STACK)
    private Stack<Double> stack;
    @MyAnnotation(argtype = ArgType.DEFINITIONS)
    private Map<String, Double> varMap;
    @MyAnnotation(argtype = ArgType.CONTEXT)
    private String[] arguments;

    public void execute(){
        try {
            String s = arguments[1];
            if (isNumber(s)) {
                stack.push(Double.valueOf(s));
            }
            else if(varMap.containsKey(s)){
                stack.push(varMap.get(s));
            }
            else {
                System.out.println("You did not define current variable");
            }
        }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("You did not config the variable");
        }
    }

    private boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
