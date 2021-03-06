package com.example.cefaloschoolproject.commands;

import com.example.cefaloschoolproject.commandHandlers.ContainsCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContainsCommand extends ICommand<ContainsCommandHandler>{
    private String word;
    @Autowired
    public ContainsCommand(ContainsCommandHandler commandHandler) {
        super(commandHandler);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
