package com.lld.splitwise.commands;

public interface Command {

    void execute(String input);

    boolean matches(String input);

}
