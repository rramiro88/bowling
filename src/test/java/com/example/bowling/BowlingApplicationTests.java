package com.example.bowling;

import com.example.bowling.services.BowlingService;
import com.example.bowling.services.PrintScoresService;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BowlingApplicationTests {

    @Autowired
    private BowlingService bowlingService;

    @Autowired
    private PrintScoresService printScoresService;

    @Test
    void testSample() {

        List<Integer> pinfalls = Arrays.asList(10, 7, 3, 9, 0, 10, 0, 8, 8, 2, 0, 6, 10, 10, 10, 8, 1);

        List<Integer> expResult = Arrays.asList(20, 39, 48, 66, 74, 84, 90, 120, 148, 167);
        List<Integer> result = bowlingService.calculateScore(pinfalls);
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        printScoresService.printScores("Sample", pinfalls, result);

        expResult.stream().forEach(value -> {
            Assertions.assertTrue(out.toString().contains(value.toString()));
        });

    }

    @Test
    public void testPerfect() {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        List<Integer> pinfalls = Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        List<Integer> expResult = Arrays.asList(30, 60, 90, 120, 150, 180, 210, 240, 270, 300);
        List<Integer> result = bowlingService.calculateScore(pinfalls);

        printScoresService.printScores("Perfect", pinfalls, result);

        expResult.stream().forEach(value -> {
            Assertions.assertTrue(out.toString().contains(value.toString()));
        });

    }
    
    @Test
    public void testZeros(){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        
        List<Integer> pinfalls = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        List<Integer> expResult = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        List<Integer> result = bowlingService.calculateScore(pinfalls);

        printScoresService.printScores("Zeros", pinfalls, result);

        expResult.stream().forEach(value -> {
            Assertions.assertTrue(out.toString().contains(value.toString()));
        });
        
    }

}
