package com.lld.splitwise.commands;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpGroupCommand implements Command{
    @Override
    public void execute(String input) {

    }

    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        return words.size()==3 && words.get(1).equalsIgnoreCase(CommandKeywords.settleUp);
    }
}
