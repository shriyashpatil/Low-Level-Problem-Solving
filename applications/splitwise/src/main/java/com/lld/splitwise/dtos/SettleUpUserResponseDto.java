package com.lld.splitwise.dtos;

import com.lld.splitwise.models.Expense;
import com.lld.splitwise.models.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SettleUpUserResponseDto {
    List<Expense> expenses;
    ResponseStatus responseStatus;

}
