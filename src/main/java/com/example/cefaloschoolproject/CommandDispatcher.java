package com.example.cefaloschoolproject;

import com.example.cefaloschoolproject.commandHandlers.ExitCommandHandler;
import com.example.cefaloschoolproject.commandHandlers.HelpCommandHandler;
import com.example.cefaloschoolproject.commands.ExitCommand;
import com.example.cefaloschoolproject.commands.HelpCommand;
import com.example.cefaloschoolproject.commands.ICommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandDispatcher {
    @Autowired
    private HelpCommandHandler helpCommandHandler;
    @Autowired
    private ExitCommandHandler exitCommandHandler;
    public void dispatch(ICommand command) {
        if(command instanceof HelpCommand){
            helpCommandHandler.handle((HelpCommand)command);
        }
        if(command instanceof ExitCommand){
            exitCommandHandler.handle((ExitCommand)command);
        }
    }
}
