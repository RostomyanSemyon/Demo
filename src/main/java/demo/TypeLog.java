package demo;

import org.apache.log4j.Logger;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;
import java.util.EmptyStackException;
import java.util.Stack;

public class TypeLog implements InvocationHandler {
    Command command;
    Stack stack;
    String[] arguments;

    public TypeLog(Command command, Stack stack, String[] arguments){
        this.command = command;
        this.stack = stack;
        this.arguments = arguments;
    }

    private static final Logger logger = Logger.getLogger(Main.class);

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {

        try{
            logger.info("Before: Stack peek is " + this.stack.peek());
        }
        catch (EmptyStackException ex){
            logger.info("Stack is empty before op's");
        }
        switch (arguments.length){
            case 1: logger.info("Command is " + arguments[0]);
            break;
            case 2: logger.info("Command is '" + arguments[0] + " " + arguments[1] + "'");
            break;
            case 3: logger.info("Command is '" + arguments[0] + " " + arguments[1] + " " + arguments[2] + "'");
            break;
        }
        method.invoke(command);
        try{
            logger.info("After: Stack peek is " + this.stack.peek());
        }
        catch (EmptyStackException ex){
            logger.info("Stack is empty after op's");
        }
        return null;
    }
}
