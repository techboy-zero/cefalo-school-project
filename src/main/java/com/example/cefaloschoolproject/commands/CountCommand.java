package com.example.cefaloschoolproject.commands;

import com.example.cefaloschoolproject.commandHandlers.CountCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountCommand extends ICommand<CountCommandHandler>{

    private String prefix;
    @Autowired
    public CountCommand(CountCommandHandler commandHandler) {
        super(commandHandler);
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
