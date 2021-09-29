package com.infosys.learning.service;

import com.infosys.learning.dto.Data;
import com.infosys.learning.dto.DataPersonal;
import com.infosys.learning.dto.Person;
import com.infosys.learning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

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

    public DataPersonal getPerson(String name, int yearOfBirth){

        Calendar calendar = Calendar.getInstance();
        int thisYear = calendar.get(Calendar.YEAR);
        int age = thisYear - yearOfBirth;

        Data data = new Data();
        data.setAge(age);

        return new DataPersonal(name, data);
    }
}
