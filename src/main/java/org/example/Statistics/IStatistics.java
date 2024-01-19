package org.example.Statistics;

public interface IStatistics<T> {
    public void AddValue(T value);
    public void PrintShortStatistic();
    public void PrintFullStatistic();

}
