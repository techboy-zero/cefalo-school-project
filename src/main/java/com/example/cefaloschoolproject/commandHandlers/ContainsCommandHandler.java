package com.example.cefaloschoolproject.commandHandlers;

import com.example.cefaloschoolproject.IDictionary;
import com.example.cefaloschoolproject.commands.ContainsCommand;
import com.example.cefaloschoolproject.commands.ICommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContainsCommandHandler extends ICommandHandler{
    @Autowired
    private IDictionary dictionary;
    @Override
    public void handle(ICommand command) {
        ContainsCommand containsCommand = (ContainsCommand)command;
        if(dictionary.contains(containsCommand.getWord())){
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
    }
}
