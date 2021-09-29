package com.infosys.learning.repository;

import com.infosys.learning.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserNameAndPassWord(String username, String password);
    User findByUserName(String username);

}
