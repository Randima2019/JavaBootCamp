package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class carController {

    @RequestMapping("/cars")
    public List<car> getAllCars(){
        return Arrays.asList(
          new car("e10","Toyata", "black"),
          new car("e10","Toyata corolla", "blue"),
          new car("e10","Toyata Yaris", "white")
        );
    }

}
