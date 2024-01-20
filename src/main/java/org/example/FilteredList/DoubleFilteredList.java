package org.example.FilteredList;

import org.example.Statistics.DoublesStatistics;

public class DoubleFilteredList extends FilteredList<Double> {
    public DoubleFilteredList(){
        statistics = new DoublesStatistics();
        fileName = "floats.txt";
    }
    @Override
    public boolean TryAddToList(String line) {
        try{
            double value = Double.parseDouble(line);
            this.add(line);
            statistics.AddValue(value);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
