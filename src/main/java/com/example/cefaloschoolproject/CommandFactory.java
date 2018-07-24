package com.example.cefaloschoolproject;

import com.example.cefaloschoolproject.commands.*;
import org.apache.commons.cli.CommandLine;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CommandFactory {
    public ICommand buildCommand(CommandLine cmd){
        if(cmd.hasOption("help")){
            return new HelpCommand();
        }
        if(cmd.hasOption("exit")){
            return new ExitCommand();
        }
        if(cmd.hasOption("insert")){
            String insert = cmd.getOptionValue("insert");
            System.out.println(insert);
            InsertWordsCommand command = new InsertWordsCommand();
            command.setWords(Arrays.asList(insert.split(",")));
            return command;
        }
        if(cmd.hasOption("count")){
            CountCommand command = new CountCommand();
            String prefix= cmd.getOptionValue("count");
            command.setPrefix(prefix);
            System.out.println(command.getPrefix());
            return command;
        }
        if(cmd.hasOption("contains")){
            ContainsCommand command = new ContainsCommand();
            String prefix= cmd.getOptionValue("contains");
            command.setPrefix(prefix);
            System.out.println(command.getPrefix());
            return command;
        }
        if(cmd.hasOption("prefix")){
            PrefixCommand command = new PrefixCommand();
            String arg = cmd.getOptionValue("prefix");
            String[] split = arg.split(" ");
            String prefix = split[0];
            int count = 20;
            if(split.length>1){
                count = Math.min(count,Integer.parseInt(split[1]));
            }
            command.setPrefix(prefix);
            command.setCount(count);
            System.out.println(command.getPrefix() + " " + command.getCount());
            return command;
        }

        throw new RuntimeException("Option not found");
    }
}
