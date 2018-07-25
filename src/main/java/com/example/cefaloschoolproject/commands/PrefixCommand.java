package com.example.cefaloschoolproject.commands;

import com.example.cefaloschoolproject.commandHandlers.PrefixCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrefixCommand extends ICommand<PrefixCommandHandler> {
    private String prefix;
    private int count;
    @Autowired
    public PrefixCommand(PrefixCommandHandler commandHandler) {
        super(commandHandler);
    }

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
