package com.shri.bookmyshow.services;

import com.shri.bookmyshow.exceptions.UserExistException;
import com.shri.bookmyshow.exceptions.UserNotFoundException;
import com.shri.bookmyshow.models.User;
import com.shri.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    /*
        1. check if the user already exists
        2. if yes, ask them to login
        3. if not, create new user object with given details and save it to database
        4. save it in DB
     */
    public User signUp(String name,String email,String password) throws UserExistException{

        Optional<User> userOptional = userRepository.findByEmail(email);

        if(!userOptional.isEmpty()){
            throw new UserExistException("please login");
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        return userRepository.save(user);
    }





}
