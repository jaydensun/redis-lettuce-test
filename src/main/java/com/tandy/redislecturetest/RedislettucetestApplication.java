package com.tandy.redislecturetest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class RedislettucetestApplication implements CommandLineRunner {

    @Autowired
    TestBean testBean;

    public static void main(String[] args) {
        SpringApplication.run(RedislettucetestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String key = "test-11111-time";
        testBean.setValue(key, new Date().toString());
        System.out.println("testBean.getValue(key) = " + testBean.getValue(key));

    }
}
