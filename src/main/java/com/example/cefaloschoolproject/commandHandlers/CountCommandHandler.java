package com.example.cefaloschoolproject.commandHandlers;

import com.example.cefaloschoolproject.commands.CountCommand;
import com.example.cefaloschoolproject.commands.ExitCommand;
import org.springframework.stereotype.Component;

@Component
public class CountCommandHandler extends ICommandHandler<CountCommand>{
    @Override
    public void handle(CountCommand command) {

    }
}
