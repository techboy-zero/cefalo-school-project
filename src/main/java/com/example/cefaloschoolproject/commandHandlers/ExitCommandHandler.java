package com.example.cefaloschoolproject.commandHandlers;

import com.example.cefaloschoolproject.CommandLineOptions;
import com.example.cefaloschoolproject.commands.ExitCommand;
import com.example.cefaloschoolproject.commands.HelpCommand;
import org.apache.commons.cli.HelpFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExitCommandHandler extends ICommandHandler<ExitCommand>{
    @Override
    public void handle(ExitCommand command) {
        System.exit(0);
    }
}
