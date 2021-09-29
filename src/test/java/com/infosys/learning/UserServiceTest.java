package com.infosys.learning;

import com.infosys.learning.dto.UserRequest;
import com.infosys.learning.model.User;
import com.infosys.learning.repository.UserRepository;
import com.infosys.learning.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyLong;

@SpringBootTest
public class UserServiceTest {

    @Autowired private UserService userService;

    @MockBean
    @Autowired private UserRepository userRepository;

    @BeforeEach
    public void init(){
        Mockito.when(userRepository.getById(anyLong())).thenReturn(new User());
    }

    @Test
    public void get_User_souldNotNull(){
        User user = userService.getUser(1L);
        Assertions.assertNotNull(user);
        System.out.println(user.getUserName());
    }
}
