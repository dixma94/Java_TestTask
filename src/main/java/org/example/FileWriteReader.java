package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileWriteReader {
    public void WriteToFile(List<String> strings, String path, boolean append) throws Exception {
        if (strings.isEmpty()) return;
        try(FileWriter writer = new FileWriter(path, append))
        {
            for (String line:strings) {
                writer.append(line);
                writer.append('\n');
            }
            writer.flush();
        }
    }
    public List<String> GetLines(String file) throws Exception{
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        }
    }
}
