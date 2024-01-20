package org.example.Statistics;

import java.math.BigDecimal;

public class DoublesStatistics implements IStatistics<Double> {
    private double max = 0;
    private double min = Double.MAX_VALUE;
    private BigDecimal sum =BigDecimal.valueOf(0);
    private int count = 0;
    public void AddValue(Double value) {
        if(value>max) max = value;
        if(value<min) min = value;
        count++;
        sum = sum.add(BigDecimal.valueOf(value));
    }
    public void PrintShortStatistic(){
        if (count==0) return;
        System.out.println("Floats count: "+ count);
    }

    public void PrintFullStatistic(){
        if (count==0) return;
        System.out.println("Floats full statistics:"+ "\n"
                +"count:\t\t"+ count + "\n"
                +"max:\t\t" +max +"\n"
                +"min:\t\t"+ min+"\n"
                +"sum:\t\t" + sum +"\n"
                +"average:\t" + GetAverage());
        System.out.println();
    }
    private double GetAverage(){
        return sum.doubleValue() /count;
    }
}
