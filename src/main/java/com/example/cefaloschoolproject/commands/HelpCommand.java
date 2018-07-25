package com.example.cefaloschoolproject.commands;

import com.example.cefaloschoolproject.commandHandlers.HelpCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelpCommand extends  ICommand<HelpCommandHandler>{
    @Autowired
    public HelpCommand(HelpCommandHandler commandHandler) {
        super(commandHandler);
    }
}
