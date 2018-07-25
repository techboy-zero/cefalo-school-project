package com.example.cefaloschoolproject.commandHandlers;

import com.example.cefaloschoolproject.CommandLineOptions;
import com.example.cefaloschoolproject.commands.ExitCommand;
import com.example.cefaloschoolproject.commands.HelpCommand;
import com.example.cefaloschoolproject.commands.ICommand;
import org.apache.commons.cli.HelpFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExitCommandHandler extends ICommandHandler{
    public void handle(ICommand command) {
        System.exit(0);
    }
}
