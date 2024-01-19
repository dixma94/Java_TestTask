package org.example.OptionsDir;

import org.example.OptionsDir.OptionOperation;

public class OptionAction{
    public boolean hasParameter;
    public OptionOperation operation;
    public String optionName;
    public  OptionAction(String optionName,boolean hasParameter, OptionOperation operation){
        this.hasParameter = hasParameter;
        this.operation = operation;
        this.optionName = optionName;
    }
}
