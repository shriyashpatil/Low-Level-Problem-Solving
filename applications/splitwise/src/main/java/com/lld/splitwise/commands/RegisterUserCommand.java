package com.lld.splitwise.commands;

import org.springframework.stereotype.Component;

@Component
public class RegisterUserCommand implements Command{
    @Override
    public void execute(String input) {

    }

    @Override
    public boolean matches(String input) {
        return false;
    }
}
