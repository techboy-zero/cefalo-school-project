package com.example.cefaloschoolproject.commandHandlers;

import com.example.cefaloschoolproject.IDictionary;
import com.example.cefaloschoolproject.commands.ICommand;
import com.example.cefaloschoolproject.commands.RemoveCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoveCommandHandler extends ICommandHandler{
    @Autowired
    private IDictionary dictionary;
    @Override
    public void handle(ICommand command) {
        RemoveCommand removeCommand = (RemoveCommand) command;
        dictionary.remove(removeCommand.getWord());
    }
}
