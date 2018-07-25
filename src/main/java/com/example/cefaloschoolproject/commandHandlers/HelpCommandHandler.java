package com.example.cefaloschoolproject.commandHandlers;

import com.example.cefaloschoolproject.CommandLineOptions;
import com.example.cefaloschoolproject.commands.HelpCommand;
import com.example.cefaloschoolproject.commands.ICommand;
import org.apache.commons.cli.HelpFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class HelpCommandHandler extends ICommandHandler{
    @Override
    public void handle(ICommand command) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "ant", options );
    }
}
