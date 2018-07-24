package com.example.cefaloschoolproject.commandHandlers;

import com.example.cefaloschoolproject.CommandLineOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public abstract class ICommandHandler<ICommand> {
    @Autowired
    protected CommandLineOptions options;
    abstract void handle(ICommand command);
}
