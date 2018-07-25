package com.example.cefaloschoolproject;

import com.example.cefaloschoolproject.commands.*;
import org.apache.commons.cli.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CommandFactory {
    @Autowired
    private ApplicationContext applicationContext;
    public ICommand buildCommand(CommandLine cmd){
//
//        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
//        for(String beanName : allBeanNames) {
//            System.out.println(beanName);
//        }

        if(cmd.hasOption("help")){
            return (HelpCommand) applicationContext.getBean("helpCommand");
        }

        if(cmd.hasOption("exit")){
            return (ExitCommand) applicationContext.getBean("exitCommand");
        }
        if(cmd.hasOption("insert")){
            String insert = cmd.getOptionValue("insert");
            System.out.println(insert);
            InsertWordsCommand command = (InsertWordsCommand) applicationContext.getBean("insertWordsCommand");
            command.setWords(Arrays.asList(insert.split(",")));
            return command;
        }
        if(cmd.hasOption("count")){
            CountCommand command = (CountCommand) applicationContext.getBean("countCommand");
            String prefix= cmd.getOptionValue("count");
            command.setPrefix(prefix);
            System.out.println(command.getPrefix());
            return command;
        }
        if(cmd.hasOption("contains")){
            ContainsCommand command = (ContainsCommand) applicationContext.getBean("containsCommand");
            String prefix= cmd.getOptionValue("contains");
            command.setPrefix(prefix);
            System.out.println(command.getPrefix());
            return command;
        }
        if(cmd.hasOption("prefix")){
            PrefixCommand command = (PrefixCommand) applicationContext.getBean("prefixCommand");
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
