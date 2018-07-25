package com.example.cefaloschoolproject.commands;

import com.example.cefaloschoolproject.commandHandlers.RemoveCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoveCommand extends ICommand<RemoveCommandHandler>{
    private String word;
    @Autowired
    public RemoveCommand(RemoveCommandHandler commandHandler) {
        super(commandHandler);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
