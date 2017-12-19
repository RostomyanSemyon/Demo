package com.jcourse.rostomyan;

/**
 * Created by Semyon Rostomyan on 30.11.2017.
 */
public class Comment implements Command {

    @MyAnnotation(argtype = ArgType.CONTEXT)
    private String[] arguments;

    public void execute() {
        return;
    }
}

