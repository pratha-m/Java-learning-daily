package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    private String message;

  
    @Autowired
    public void setMessage(String message){
        this.message=message;
    }

    public String getMessage(){
        return this.message;
    }

}
