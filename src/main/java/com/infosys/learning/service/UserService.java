package com.infosys.learning.service;

import com.infosys.learning.dto.UserRequest;
import com.infosys.learning.model.User;
import com.infosys.learning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String register(UserRequest userRequest){
        User existUser = userRepository.findByUserName(userRequest.getUsername());

        if (existUser !=null){
            return "Register failed, username is already exist";
        }

        User user = new User();
        user.setUserName(userRequest.getUsername());
        user.setPassWord(userRequest.getPassword());
        userRepository.save(user);

        return "Register Success !";
    }


    public User login(UserRequest userRequest){
        User checkUser = userRepository.findByUserNameAndPassWord(userRequest.getUsername(), userRequest.getPassword());

        if (checkUser != null){
            return userRepository.findByUserNameAndPassWord(userRequest.getUsername(), userRequest.getPassword());
        }
        return null;
    }

    public User getUser(Long id){
        return userRepository.getById(id);
    }
}
