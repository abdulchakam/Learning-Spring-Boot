package com.infosys.learning.dto;

import org.springframework.stereotype.Service;

public class Person {

    private String name;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}