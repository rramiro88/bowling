/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bowling.services;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ramiro
 */
public interface FileService {
    Map<String, List<Integer>> parseFile(String path, String separator) throws FileNotFoundException;
}
