/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bowling.services;

import java.io.BufferedReader;
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
    public Map<String, List<Integer>> parseFile(String filePath, String separator) throws Exception {

        FileReader input = new FileReader(filePath);
        BufferedReader br = new BufferedReader(input);
        Map<String, List<Integer>> lines = new HashMap<>();

        String l;
        while ((l = br.readLine()) != null) {
            String[] line = l.split(separator);

            if (lines.get(line[0]) == null) {
                lines.put(line[0], new ArrayList<>());
            }

            validate(line);

            List<Integer> shots = lines.get(line[0]);
            Integer value;
            try {
                value = Integer.parseInt(line[1]);
            } catch (NumberFormatException e) {
                value = 0;
            }

            shots.add(value);
            lines.put(line[0], shots);
        }

        return lines;
    }

    private void validate(String[] line) throws Exception {
        String value = null;
        try {

            if(line==null || line.length!=2){
                throw new Exception("Invalid input file. Please check");
            }
            
            value = line[1];
            Integer intValue = Integer.parseInt(value);
            if (intValue < 0 || intValue > 10) {
                throw new Exception("Pinfall value outside limits");
            }

        } catch (NumberFormatException e) {

            if (!value.equals("F")) {
                throw new Exception("Invalid input file. Please check");
            }

        }

    }

}
