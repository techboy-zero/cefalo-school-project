package com.example.cefaloschoolproject.commandHandlers;

import com.example.cefaloschoolproject.CommandLineOptions;
import com.example.cefaloschoolproject.commands.ICommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public abstract class ICommandHandler{
    @Autowired
    protected CommandLineOptions options;
    public abstract void handle(ICommand command);
}
