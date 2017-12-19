package com.jcourse.rostomyan;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by Semyon Rostomyan on 08.12.2017.
 */
public class Main {

    public static void main(String[] args) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {

        Stack<Double> stack = new Stack<>();
        Map<String, Double> variableMap = new HashMap<>();
        InputStream in = Main.class.getClassLoader().getResourceAsStream("commands");
        Properties properties = new Properties();
        properties.load(in);
        Factory factory = new Factory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("start typing..");
        CalcState calcState = new CalcState(stack,variableMap,null);
        while (scanner.hasNextLine()) {

            //String[] command = factory.readCommand(scanner.nextLine());
            CommandReader commandReader = new CommandReader();
            String[] command = commandReader.readCommand(scanner.nextLine());
            calcState.updateCommandSignature(command);
            //factory.createCommand(stack, variableMap, command, properties).execute();
            factory.createCommand(calcState, properties).execute();
        }
    }
}
