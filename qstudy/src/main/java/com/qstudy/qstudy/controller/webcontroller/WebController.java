package com.qstudy.qstudy.controller.webcontroller;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qstudy.qstudy.dto.calendar.Calendar;
import com.qstudy.qstudy.dto.group.GroupList;
import com.qstudy.qstudy.service.calendar.CalendarService;


@Controller
public class WebController {
  @GetMapping(value =  {"/", "/login"})
    public String forward() {
      System.out.println("[TEST]");
        return "forward:/index.html";
    }
}
