package com.example.cefaloschoolproject.commands;

import com.example.cefaloschoolproject.commandHandlers.ExitCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExitCommand extends ICommand<ExitCommandHandler>{
    @Autowired
    public ExitCommand(ExitCommandHandler commandHandler) {
        super(commandHandler);
    }
}
