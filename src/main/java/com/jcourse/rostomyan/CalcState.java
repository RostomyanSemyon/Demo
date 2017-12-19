package com.jcourse.rostomyan;

import java.util.Map;
import java.util.Stack;

/**
 * Created by Semyon Rostomyan on 16.12.2017.
 */
public class CalcState {
    private Stack stack;
    private Map<String, Double> varMap;
    private String[] commandSignature;

    CalcState(Stack stack, Map<String, Double> varMap, String[] commandSignature){
        this.stack = stack;
        this.varMap =varMap;
        this.commandSignature = commandSignature;
    }

    public Stack getStack(){
        return this.stack;
    }
    public Map<String, Double> getVarMap(){
        return this.varMap;
    }
    public String[] getCommandSignature(){
        return this.commandSignature;
    }
    public void updateCommandSignature(String[] commandSignature){
        this.commandSignature = commandSignature;
    }
}
