package com.jcourse.rostomyan;

/**
 * Created by Semyon Rostomyan on 16.12.2017.
 */
public class CommandReader {

    public String[] readCommand(String command) {
        return command.split(" ");
    }
}
