
package com.jcourse.rostomyan;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.text.Annotation;
import java.util.*;


/**
 * Created by Semyon Rostomyan on 08.12.2017.
 */
//public class Factory {
//
//    public Command createCommand(Stack stack, Map<String, Double> definitions, String[] commandSignature, Properties properties) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//    String concreteCommand = commandSignature[0];
//    Class ccm = Class.forName(properties.getProperty(concreteCommand));
//    Command command = (Command) ccm.newInstance();
//    ccm.getFields();
//    for (Field f : ccm.getDeclaredFields()) {
//        f.setAccessible(true);
//        if (f.getName().equals("stack")) {
//            f.set(command, stack);
//        }
//        if (f.getName().equals("varMap")) {
//            f.set(command, definitions);
//        }
//        if (f.getName().equals("arguments")) {
//            f.set(command, commandSignature);
//        }
//    }
//    return command;
//}
public class Factory {

    //public Command createCommand(Stack stack, Map<String, Double> definitions, String[] commandSignature, Properties properties) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        String concreteCommand = commandSignature[0];
//        Class ccm = Class.forName(properties.getProperty(concreteCommand));
//        Command command = (Command) ccm.newInstance();
//        ccm.getFields();
//        for (Field f : ccm.getDeclaredFields()) {
//            f.setAccessible(true);
//            if (f.getName().equals("stack")) {
//                f.set(command, stack);
//            }
//            if (f.getName().equals("varMap")) {
//                f.set(command, definitions);
//            }
//            if (f.getName().equals("arguments")) {
//                f.set(command, commandSignature);
//            }
//        }
//        Command commandproxy = (Command) Proxy.newProxyInstance(ccm.getClassLoader(), ccm.getInterfaces(), new TypeLog(command, stack, commandSignature));
//        return commandproxy;
//    }

    public Command createCommand(CalcState calcState, Properties properties) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String concreteCommand = calcState.getCommandSignature()[0];
        Class ccm = Class.forName(properties.getProperty(concreteCommand));
        Command command = (Command) ccm.newInstance();
        //ccm.getFields();
//        for (Field f : ccm.getDeclaredFields()) {
//            f.setAccessible(true);
//            if (f.getName().equals("stack")) {
//                f.set(command, calcState.getStack());
//            }
//            if (f.getName().equals("varMap")) {
//                f.set(command, calcState.getVarMap());
//            }
//            if (f.getName().equals("arguments")) {
//                f.set(command, calcState.getCommandSignature());
//            }
//        }
        for (Field f: ccm.getDeclaredFields()){
            f.setAccessible(true);
            switch (f.getAnnotation(MyAnnotation.class).argtype()){
                case STACK: f.set(command, calcState.getStack());
                    break;
                case DEFINITIONS: f.set(command, calcState.getVarMap());
                    break;
                case CONTEXT: f.set(command,calcState.getCommandSignature());
                    break;
                default: new RuntimeException("Field doesn't exist");
            }
        }
//        Command commandproxy = (Command) Proxy.newProxyInstance(ccm.getClassLoader(), ccm.getInterfaces(), new TypeLog(command, stack, commandSignature));
//        return commandproxy;
        //return command;
        Command commandproxy = (Command) Proxy.newProxyInstance(ccm.getClassLoader(), ccm.getInterfaces(), new TypeLog(command, calcState));
        return commandproxy;
    }

//    public String[] readCommand(String command){
//        return command.split(" ");
//    }
}
