package net.javaguides.springboot.Temp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Temp {
    @Autowired
    private AutoFile auto;

    public void func1(){
        System.out.println(auto);
    }
}
