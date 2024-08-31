package com.shri.bookmyshow;

import com.shri.bookmyshow.controllers.UserController;
import com.shri.bookmyshow.dtos.SignUpRequestDto;
import com.shri.bookmyshow.dtos.SignUpResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookmyshowApplicationTests {


	@Autowired
	private UserController userController;

	@Test
	void contextLoads() {
	}

	@Test
	public void sampleTestCase(){

		SignUpRequestDto requestDto = new SignUpRequestDto();

		requestDto.setEmail("shriyashpatil74@gmail.com");
		requestDto.setName("Shriyash Patil");
		requestDto.setPassword("xyz");

		SignUpResponseDto signUpResponseDto = userController.signUp(requestDto);

		System.out.println("UserId : "+ signUpResponseDto.getUserId()+" | Status : "+signUpResponseDto.getResponseStatus());

	}

}
