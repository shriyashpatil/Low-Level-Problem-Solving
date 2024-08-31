package com.shri.bookmyshow.controllers;

import com.shri.bookmyshow.dtos.ResponseStatus;
import com.shri.bookmyshow.dtos.SignUpRequestDto;
import com.shri.bookmyshow.dtos.SignUpResponseDto;
import com.shri.bookmyshow.models.User;
import com.shri.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto){
        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
        try {
            User user = userService.signUp(signUpRequestDto.getName(),signUpRequestDto.getEmail(),signUpRequestDto.getPassword());

            signUpResponseDto.setUserId(user.getId());
            signUpResponseDto.setResponseStatus(ResponseStatus.SUCCESS);

        }catch (Exception e){
            signUpResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return signUpResponseDto;
    }

}
