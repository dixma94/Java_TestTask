package org.example.FilteredList;

import org.example.Statistics.PrintStatisticsMode;
import org.example.Statistics.IStatistics;

import java.util.ArrayList;

public abstract class FilteredList<T> extends ArrayList<String> {
    protected String fileName;
    protected IStatistics<T> statistics;
    public abstract boolean TryAddToList(String line);
    public void PrintStatistics(PrintStatisticsMode mode){
        switch (mode) {
            case SHORT_STATISTICS -> {
                statistics.PrintShortStatistic();
            }
            case FULL_STATISTICS -> {
                statistics.PrintFullStatistic();
            }
            case NO_STATISTICS -> {
            }
        }
    }
    public String getFileName() {
        return fileName;
    }
}
