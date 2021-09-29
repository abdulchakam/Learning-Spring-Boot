package com.infosys.learning;

import com.infosys.learning.dto.DataPersonal;
import com.infosys.learning.dto.Person;
import com.infosys.learning.service.LearningService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LearningServiceTest {

    @Autowired private LearningService learningService;

    @Test
    public void getPerson_souldNotNull(){
        DataPersonal dataPersonal = learningService.getPerson("abdulchakam",1990);
        Assertions.assertNotNull(dataPersonal);
    }

    @Test
    public void getNameV2_souldNotNull(){
        Person person = learningService.getNameV2("man");
        Assertions.assertNotNull(person);
        System.out.println(person.getName());
    }
    @Test
    public void getNameV3_souldNotNull(){
        String getName = learningService.getNameV3("John");
        Assertions.assertNotNull(getName);
        System.out.println(getName);
    }
}
