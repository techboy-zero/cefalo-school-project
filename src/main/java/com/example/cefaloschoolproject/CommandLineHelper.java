package com.example.cefaloschoolproject;

import com.example.cefaloschoolproject.commands.ICommand;
import org.apache.commons.cli.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CommandLineHelper {
    @Autowired
    private CommandFactory commandFactory;
    @Autowired
    private CommandLineOptions options;

    public ICommand parse(String args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse( options, new String[]{args});
        return commandFactory.buildCommand(cmd);
    }
}
