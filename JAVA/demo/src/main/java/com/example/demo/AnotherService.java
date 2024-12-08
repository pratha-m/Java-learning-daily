package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnotherService {
    private MyService myService;

    @Autowired
    public AnotherService(MyService myService){
        this.myService=myService;
    }

    public AnotherService(){

    } 

    public void printMessage(){
        System.out.println(myService.getMessage());
    }
}
