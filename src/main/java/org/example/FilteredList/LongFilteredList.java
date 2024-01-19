package org.example.FilteredList;

import org.example.Statistics.LongStatistics;

public class LongFilteredList extends FilteredList<Long> {
    public LongFilteredList(){
        statistics = new LongStatistics();
        fileName = "integers.txt";
    }
    @Override
    public boolean TryAddToList(String line){
        try{
            Long value = Long.parseLong(line);
            this.add(line);
            statistics.AddValue(value);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}