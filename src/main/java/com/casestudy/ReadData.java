package com.casestudy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadData {
    List<String> getReadData(String fileName) throws IOException {
        List<String> readerData = new ArrayList<>();
        // Try-with-resources to ensure the reader gets closed automatically
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                readerData.add(line);
            }
        }
        readerData.remove(0);
        return readerData;
    }
}