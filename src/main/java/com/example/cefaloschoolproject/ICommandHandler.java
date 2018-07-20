package com.example.cefaloschoolproject;

public interface ICommandHandler<ICommand> {
    void handle(ICommand command);
}
