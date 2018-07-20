package com.example.cefaloschoolproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CommandDispatcher {
    @Autowired
    private HelpCommandHandler helpCommandHandler;
    public void dispatch(ICommand command) {
        if(command instanceof HelpCommand){
            helpCommandHandler.handle((HelpCommand)command);
        }
    }
}
