package com.example.cefaloschoolproject.commandHandlers;

import com.example.cefaloschoolproject.commands.ExitCommand;
import com.example.cefaloschoolproject.commands.InsertWordsCommand;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Component
public class InsertWordsCommandHandler extends ICommandHandler<InsertWordsCommand>{
    @Override
    public void handle(InsertWordsCommand command) {
        System.out.println(command.getWords());
    }
}
