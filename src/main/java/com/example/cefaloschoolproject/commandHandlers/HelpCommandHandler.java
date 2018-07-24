package com.example.cefaloschoolproject.commandHandlers;

import com.example.cefaloschoolproject.CommandLineOptions;
import com.example.cefaloschoolproject.commands.HelpCommand;
import org.apache.commons.cli.HelpFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class HelpCommandHandler extends ICommandHandler<HelpCommand>{
    @Override
    public void handle(HelpCommand command) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "ant", options );
    }
}
