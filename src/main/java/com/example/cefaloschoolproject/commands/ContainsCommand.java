package com.example.cefaloschoolproject.commands;

import com.example.cefaloschoolproject.commandHandlers.ContainsCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContainsCommand extends ICommand<ContainsCommandHandler>{
    private String prefix;
    @Autowired
    public ContainsCommand(ContainsCommandHandler commandHandler) {
        super(commandHandler);
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
