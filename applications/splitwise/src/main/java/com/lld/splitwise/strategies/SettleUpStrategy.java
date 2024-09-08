package com.lld.splitwise.strategies;

import com.lld.splitwise.models.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<Expense> settleUp(List<Expense> expenses);

}
