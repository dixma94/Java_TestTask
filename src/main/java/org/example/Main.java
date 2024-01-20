package org.example;

import org.example.FilteredList.*;
import org.example.OptionsDir.Options;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        args = new String[]{"in1.txt","in2.txt"};
        if (args.length == 0) throw new Exception("Missing input text files. Specify the path to the input file");

        FileWriteReader fileWriteReader = new FileWriteReader();
        Filter filter = new Filter();

        Options options;
        try {
            options = new Options(args);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        List<FilteredList> filteredLists = new ArrayList<>();
        filteredLists.add(new LongFilteredList());
        filteredLists.add(new DoubleFilteredList());
        filteredLists.add(new StringFilteredList());

        filter.SetFilteredLists(filteredLists);
        try {
            for(String inputFilePath: options.getListInputFilePaths()){
                filter.ReadFile(inputFilePath, fileWriteReader);
            }
            System.out.println();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        filter.WriteToFile(fileWriteReader, options.GetOutputPath(), options.isAppend());
        filter.PrintStatistics(options.getStatisticsMode());

    }


}

