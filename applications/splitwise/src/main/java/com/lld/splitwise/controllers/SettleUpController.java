package com.lld.splitwise.controllers;


import com.lld.splitwise.dtos.SettleUpGroupRequestDto;
import com.lld.splitwise.dtos.SettleUpGroupResponseDto;
import com.lld.splitwise.dtos.SettleUpUserRequestDto;
import com.lld.splitwise.dtos.SettleUpUserResponseDto;
import com.lld.splitwise.models.Expense;
import com.lld.splitwise.models.ResponseStatus;
import com.lld.splitwise.services.SettleUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {

    @Autowired
    SettleUpService settleUpService;

    /// methods related to settup

    /*

            settle up functionality should return the list of transactions
            which when executed will make the net amount of a user to be ZERO
     */
    public SettleUpUserResponseDto settleUpUser(SettleUpUserRequestDto settleUpUserRequestDto){
        SettleUpUserResponseDto settleUpUserResponseDto = new SettleUpUserResponseDto();
        try {
            List<Expense> expenses = settleUpService.settleUpUser(settleUpUserRequestDto.getUserId());
            settleUpUserResponseDto.setExpenses(expenses);
            settleUpUserResponseDto.setResponseStatus(ResponseStatus.SUCCESS);

        }catch (Exception e){
            settleUpUserResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return settleUpUserResponseDto;
    }

    public SettleUpGroupResponseDto settleUpGroup(SettleUpGroupRequestDto settleUpGroupRequestDto){

        return null;
    }

}
