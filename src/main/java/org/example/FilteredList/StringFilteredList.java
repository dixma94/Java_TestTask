package org.example.FilteredList;

import org.example.Statistics.StringsStatistics;

public class StringFilteredList extends FilteredList<String> {
    public StringFilteredList(){
        this.statistics = new StringsStatistics();
        fileName = "strings.txt";
    }
    @Override
    public boolean TryAddToList(String line) {
            this.add(line);
            statistics.AddValue(line);
            return true;
    }
}
