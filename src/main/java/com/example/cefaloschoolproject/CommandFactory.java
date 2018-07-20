package com.example.cefaloschoolproject;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.springframework.stereotype.Component;

@Component
public class CommandFactory {
    public ICommand buildCommand(Options options, CommandLine cmd){
        if(cmd.hasOption("help")){
            return new HelpCommand();
        }
        throw new RuntimeException("Option not found");
    }
}
