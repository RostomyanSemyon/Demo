package com.jcourse.rostomyan;

import org.apache.log4j.Logger;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class TypeLog implements InvocationHandler {
//    private static final Logger logger = Logger.getLogger(Main.class);
//    Command command;
//    Stack stack;
//    String[] arguments;
//
//    public TypeLog(Command command, Stack stack, String[] arguments){
//        this.command = command;
//        this.stack = stack;
//        this.arguments = arguments;
//    }
private static final Logger logger = Logger.getLogger(Main.class);
    private Command command;
    private Stack stack;
    private String[] arguments;

    public TypeLog(Command command, CalcState calcState){
        this.command = command;
        this.stack = calcState.getStack();
        this.arguments = calcState.getCommandSignature();
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {

        try{
            logger.info("Before: Stack peek is " + this.stack.peek());
        }
        catch (EmptyStackException ex){
            logger.info("Stack is empty before op's");
        }
        logger.info("Command is " + Arrays.toString(arguments));
        Object result = method.invoke(command, args);
        try{
            logger.info("After: Stack peek is " + this.stack.peek());
        }
        catch (EmptyStackException ex){
            logger.info("Stack is empty after op's");
        }
        return result;
    }
}
