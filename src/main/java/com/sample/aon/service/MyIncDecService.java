package com.sample.aon.service;

import com.sample.aon.exercise.MyIncDec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MyIncDecService {

    @Value("${incdec.number}")
    private Integer number;

    public void increment() {
        MyIncDec incDec = new MyIncDec(number);
        incDec.increment();
    }

    public void decrement() {
        MyIncDec incDec = new MyIncDec(number);
        incDec.decrement();
    }
}
