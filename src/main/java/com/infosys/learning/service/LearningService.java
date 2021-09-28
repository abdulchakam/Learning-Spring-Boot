package com.infosys.learning.service;

import com.infosys.learning.dto.Person;
import com.infosys.learning.dto.UserRequest;
import com.infosys.learning.model.User;
import com.infosys.learning.repository.UserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;
import java.util.Date;

@Service
public class LearningService {

    @Autowired
    UserRepository userRepository;

    public String getName(String gender){
        Person person = new Person();

        if ("man".equals(gender)){
            person.setName("John");
        }else{
            person.setName("Jane");
        }

        return person.getName();
    }

    public Person getNameV2(String gender){
        Person person = new Person();

        if ("man".equals(gender)){
            person.setName("John");
        }else{
            person.setName("Jane");
        }
        return person;
    }

    public String getNameV3(String name){
        String fullName = "not identified";

        if ("John".equals(name)){
            fullName = "John Doe";
        }else if ("Jane".equals(name)){
            fullName = "Jane Done";
        }

        return fullName;

    }

    public Person getPerson(String name, int yearOfBirth){
        Person person = new Person();

        Calendar calendar = Calendar.getInstance();
        int thisYear = calendar.get(Calendar.YEAR);
        int age = thisYear - yearOfBirth;

        person.setName(name);
        person.setYearOfBirth(age);

        return person;
    }

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
        User checkUsername = userRepository.findByUserName(userRequest.getUsername());
        User checkPassword = userRepository.findByPassWord(userRequest.getPassword());

        if (checkUsername != null && checkPassword != null){
            return userRepository.findByUserName(userRequest.getUsername());
        }
        return null;
    }
}
