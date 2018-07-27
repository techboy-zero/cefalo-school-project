package com.example.cefaloschoolproject.commandHandlers;

import com.example.cefaloschoolproject.dictionary.IDictionary;
import com.example.cefaloschoolproject.commands.CountCommand;
import com.example.cefaloschoolproject.commands.ICommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountCommandHandler extends ICommandHandler{
    @Autowired
    private IDictionary dictionary;
    @Override
    public void handle(ICommand command) {
        CountCommand countCommand = (CountCommand) command;
        System.out.println(dictionary.count(countCommand.getPrefix()));
    }
}
