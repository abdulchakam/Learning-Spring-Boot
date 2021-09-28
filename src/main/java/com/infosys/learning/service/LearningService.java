package com.infosys.learning.service;

import com.infosys.learning.dto.Person;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;
import java.util.Date;

@Service
public class LearningService {

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
}
