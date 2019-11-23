/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bowling;

import com.example.bowling.services.BowlingService;
import com.example.bowling.services.PrintScoresService;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ramiro
 */
@Component
public class MainBean {

    @Autowired
    private BowlingService bowlingService;

    @Autowired
    private PrintScoresService printScoresService;

    public void execute() {
        try {

            System.out.println(" -------------------------------------------");
            System.out.println("|               Bowling!                    |");
            System.out.println(" -------------------------------------------");

            String homeDir = System.getProperty("user.home");
            String filePath = homeDir + "/input.txt";

            FileReader input = new FileReader(filePath);
            BufferedReader br = new BufferedReader(input);

            Map<String, List<Integer>> lines = new HashMap<>();

            br.lines().forEach(l -> {
                String[] line = l.split(" ");

                if (lines.get(line[0]) == null) {
                    lines.put(line[0], new ArrayList<>());
                }

                List<Integer> shots = lines.get(line[0]);
                Integer value;
                try {
                    value = Integer.parseInt(line[1]);
                } catch (Exception e) {
                    value = 0;
                }

                shots.add(value);
                lines.put(line[0], shots);
            });

            System.out.print("Frame \t\t");
            for (int i = 0; i < 10; i++) {
                System.out.printf("%10s", i + 1);
            }

            lines.forEach((k, v) -> {

                printScoresService.printScores(k, v, bowlingService.calculateScore(v));

            });

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
