/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bowling.services;

import java.util.List;

/**
 *
 * @author ramiro
 */
public interface PrintScoresService {
    public void printScores(String name, List<Integer> pinfalls, List<Integer> scores);
}
