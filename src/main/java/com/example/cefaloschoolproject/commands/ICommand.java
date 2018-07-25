package com.example.cefaloschoolproject.commands;

import com.example.cefaloschoolproject.commandHandlers.ICommandHandler;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ICommand<T extends ICommandHandler> {
    @Autowired
    private T commandHandler;

    public ICommand(final T commandHandler) {
        this.commandHandler = commandHandler;
    }

    public void disPatch(){
        commandHandler.handle(this);
    }
}
