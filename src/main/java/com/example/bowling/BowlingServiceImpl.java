/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bowling;

import org.springframework.stereotype.Service;

/**
 *
 * @author ramiro
 */
@Service
public class BowlingServiceImpl implements BowlingService{

    @Override
    public String doSomething() {
        return "do something from impl";
    }
    
}
