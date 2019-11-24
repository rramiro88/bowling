/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bowling.services;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ramiro
 */
@Service
public class PrintScoresServiceImpl implements PrintScoresService {

    @Override
    public void printScores(String name, List<Integer> pinfalls, List<Integer> scores) {

        System.out.print("\n" + name + "\n");
        System.out.print("Pinfalls \t");

        Integer n = 0, sum = 0;
        for (int i = 0; i < pinfalls.size(); i++) {

            n++;
            sum += pinfalls.get(i);

            if (sum == 10 && n < 2) { //was a strike
                System.out.printf("%10s","X");
//                System.out.print("\tX\t");
            } else {

                if (n == 2) {

                    if (pinfalls.get(i) + pinfalls.get(i - 1) == 10) { //was a spare
                        System.out.printf("%5s","/ ");
//                        System.out.print("/\t");
                    } else {
                        System.out.printf("%5d",pinfalls.get(i));
//                        System.out.print(pinfalls.get(i)+"\t");
                    }
                } else {
                    System.out.printf("%5d", pinfalls.get(i));
//                    System.out.print(pinfalls.get(i)+"\t");
                }

            }

            if (n == 2 || sum == 10) {
                n = 0;
                sum = 0;
            }

        }
        System.out.print("\nScores \t\t");
        for (Integer s : scores) {
            System.out.printf("%10s", s);
//            System.out.print(s+"\t\t");
        }

    }

}
