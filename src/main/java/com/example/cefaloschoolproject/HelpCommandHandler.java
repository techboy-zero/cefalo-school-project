package com.example.cefaloschoolproject;

import org.apache.commons.cli.HelpFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelpCommandHandler implements ICommandHandler<HelpCommand>{
    @Autowired
    private CommandLineOptions commandLineOptions;
    @Override
    public void handle(HelpCommand helpCommand) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "ant", commandLineOptions );
    }
}
