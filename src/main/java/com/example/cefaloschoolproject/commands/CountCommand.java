package com.example.cefaloschoolproject.commands;

public class CountCommand implements ICommand{

    private String prefix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
