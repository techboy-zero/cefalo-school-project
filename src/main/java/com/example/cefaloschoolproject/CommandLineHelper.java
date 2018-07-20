package com.example.cefaloschoolproject;

import org.apache.commons.cli.*;
import org.springframework.aop.scope.DefaultScopedObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service()
public class CommandLineHelper {
    private CommandFactory commandFactory;
    @Autowired
    private CommandLineOptions options;
    @Autowired
    public CommandLineHelper(final CommandFactory commandFactory) {
        this.commandFactory = commandFactory;

    }
    public void defineOptions(){
        Option helpOption = new Option("help", false, "Displays helps");
        options.addOption(helpOption);
    }
    public ICommand parse(String args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse( options, new String[]{args});
        return commandFactory.buildCommand(options,cmd);
    }
}
