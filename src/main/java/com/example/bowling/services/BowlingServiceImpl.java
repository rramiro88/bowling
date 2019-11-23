/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bowling.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ramiro
 */
@Service
public class BowlingServiceImpl implements BowlingService {

    @Override
    public List<Integer> calculateScore(List<Integer> pinfalls) {

        List<Integer> scores = new ArrayList<>();
        scores.add(0);
        Integer score = 0, n = 0, sum = 0;
        for (int i = 0; i < pinfalls.size()-1; i++) {
            
            sum += pinfalls.get(i);
            n++;

            if (sum == 10 && n < 2) { //was a strike
                score = pinfalls.get(i) + pinfalls.get(i + 1) + pinfalls.get(i + 2);
            } else {

                if (n == 2) {

                    if (pinfalls.get(i) + pinfalls.get(i - 1) == 10) { //was a spare
                        score = sum + pinfalls.get(i + 1);
                    } else {
                        score = sum;
                    }
                }

            }

            if (n == 2 || sum == 10) {
                n = 0;
                sum = 0;
                scores.add(scores.get(scores.size()-1)+score);
            }

            
        }
        scores.remove(0);
        return scores;

    }

}
