package com.example.cefaloschoolproject.commandHandlers;

import com.example.cefaloschoolproject.commands.ExitCommand;
import com.example.cefaloschoolproject.commands.ICommand;
import com.example.cefaloschoolproject.commands.InsertWordsCommand;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Component
public class InsertWordsCommandHandler extends ICommandHandler{
    @Override
    public void handle(ICommand command) {

        System.out.println(((InsertWordsCommand)command).getWords());
    }
}
