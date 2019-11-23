/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bowling.services;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ramiro
 */
public class BowlingServiceImplTest {
    
    public BowlingServiceImplTest() {
    }

    /**
     * Test of calculateScore method, of class BowlingServiceImpl.
     */
    @Test
    public void testCalculateScore() {

        
        List<Integer> pinfalls = Arrays.asList(10, 7, 3, 9, 0, 10, 0, 8, 8, 2, 0, 6, 10, 10, 10, 8, 1);
        BowlingServiceImpl instance = new BowlingServiceImpl();
        
        List<Integer> expResult1 = Arrays.asList(20,39,48,66,74,84,90,120,148,167);
        List<Integer> result1 = instance.calculateScore(pinfalls);
        
        List<Integer> pinfalls2 = Arrays.asList(10,10,10,10,10,10,10,10,10,10,10,10);
        List<Integer> expResult2 = Arrays.asList(30,60,90,120,150,180,210,240,270,300);
        List<Integer> result2 = instance.calculateScore(pinfalls2);
        
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
     
    }
    
}
