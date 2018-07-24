package com.example.cefaloschoolproject.commands;

public class PrefixCommand implements ICommand{
    private String prefix;
    private int count;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
