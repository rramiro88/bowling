/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bowling.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author ramiro
 */
@Service
public class FileServiceImpl implements FileService {

    @Override
    public Map<String, List<Integer>> parseFile(String filePath, String separator) throws FileNotFoundException{
        

        FileReader input = new FileReader(filePath);
        BufferedReader br = new BufferedReader(input);
        Map<String, List<Integer>> lines = new HashMap<>();

        br.lines().forEach(l -> {
            String[] line = l.split(separator);

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

        return lines;
    }

}
