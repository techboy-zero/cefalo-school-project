package com.example.cefaloschoolproject.commands;

import com.example.cefaloschoolproject.commandHandlers.InsertWordsCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class InsertWordsCommand extends ICommand<InsertWordsCommandHandler> {
    private List<String> words;
    @Autowired
    public InsertWordsCommand(InsertWordsCommandHandler commandHandler) {
        super(commandHandler);
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }
}
