package com.example.cefaloschoolproject.commandHandlers;

import com.example.cefaloschoolproject.dictionary.IDictionary;
import com.example.cefaloschoolproject.commands.ICommand;
import com.example.cefaloschoolproject.commands.InsertWordsCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InsertWordsCommandHandler extends ICommandHandler{
    @Autowired
    private IDictionary dictionary;
    @Override
    public void handle(ICommand command) {
        List<String> words = ((InsertWordsCommand) command).getWords();
        words.forEach(s -> dictionary.insert(s));
        System.out.println("RESULT ARRAY " +  words);
    }
}
