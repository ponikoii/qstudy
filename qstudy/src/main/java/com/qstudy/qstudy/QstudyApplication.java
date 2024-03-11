package com.qstudy.qstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@SpringBootApplication
@RestController
public class QstudyApplication {
	
    public static void main(String[] args) {
      SpringApplication.run(QstudyApplication.class, args);
    }

}