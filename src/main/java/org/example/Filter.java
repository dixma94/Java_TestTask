package org.example;

import org.example.FilteredList.FilteredList;
import org.example.Statistics.PrintStatisticsMode;

import java.util.ArrayList;
import java.util.List;

public class Filter {

   private List<FilteredList> lists = new ArrayList<>();

    private void FilterStrings(List<String> lines){
        for (String line:lines){
            for (FilteredList list: lists){
                if (list.TryAddToList(line)) break;
            }
        }
    }
    public void ReadFile(String inputFilePath, FileWriteReader fileWriteReader){
            try {
                List<String> lines = fileWriteReader.GetLines(inputFilePath);
                if (lines.size()==1 && lines.getFirst().isEmpty()){
                    System.out.println(inputFilePath+"\tis empty");
                    return;
                }
                FilterStrings(lines);
                System.out.println(inputFilePath+"\tis filtered");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }

    public void SetSortedLists(List<FilteredList> lists) {
        this.lists = lists;
    }

    public void PrintStatistics(PrintStatisticsMode mode){
        for (FilteredList filteredList : lists){
            filteredList.PrintStatistics(mode);
        }
    }
    public void WriteToFile(FileWriteReader fileWriteReader, String outputPath, boolean append){
        for (FilteredList filteredList : lists){
            try {
                fileWriteReader.WriteToFile(filteredList, outputPath+ filteredList.getFileName(), append);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

}
