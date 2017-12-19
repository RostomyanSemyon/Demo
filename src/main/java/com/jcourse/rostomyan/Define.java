package com.jcourse.rostomyan;

import java.util.Map;
import java.util.Stack;

/**
 * Created by Semyon Rostomyan on 01.12.2017.
 */
public class Define implements Command {

    @MyAnnotation(argtype = ArgType.STACK)
    private Stack<Double> stack;
    @MyAnnotation(argtype = ArgType.DEFINITIONS)
    private Map<String, Double> varMap;
    @MyAnnotation(argtype = ArgType.CONTEXT)
    private String[] arguments;
    public void execute(){
        try{
            varMap.put((String.valueOf(arguments[1])), Double.valueOf(arguments[2]));
        }
        catch (NumberFormatException ex){
            System.out.println("Variable is not a number");
        }
    }
}
