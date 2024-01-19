package org.example.Statistics;

public class DoublesStatistics implements IStatistics<Double> {
    private double max = 0;
    private double min = Double.MAX_VALUE;
    private double sum =0;
    private int count = 0;

    public void AddValue(Double value) {
        if(value>max) max = value;
        if(value<min) min = value;
        count++;
        sum+= value;
    }
    public void PrintShortStatistic(){
        if (count==0) return;
        System.out.println("Floats count: "+ count);
    }

    public void PrintFullStatistic(){
        if (count==0) return;
        System.out.println("Floats:"+ "\n"
                +"count: "+ count + "\n"
                +"max : " +max +"\n"
                +"min : "+ min+"\n"
                +"sum : " + sum +"\n"
                +"average: " + GetAverage());
    }
    private double GetAverage(){
        return sum /count;
    }
}
