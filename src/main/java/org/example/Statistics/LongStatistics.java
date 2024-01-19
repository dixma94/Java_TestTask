package org.example.Statistics;

public class LongStatistics implements IStatistics<Long> {

    public long min = Long.MAX_VALUE;
    public long max = 0;
    public int count = 0;
    public  long sum=0;
    public void AddValue(Long value){
        if(value>max) max = value;
        if(value<min) min = value;
        count++;
        sum+= value;
    }
    public void PrintShortStatistic(){
        if (count==0) return;
        System.out.println("Integer count: "+ count);
    }
    public void PrintFullStatistic(){
        if (count==0) return;
        System.out.println("Integers:"+ "\n"
                +"count: "+ count + "\n"
                +"max : " +max +"\n"
                +"min : "+ min+"\n"
                +"sum : " + sum +"\n"
                +"average: " + GetAverage());
    }
    private double GetAverage(){
        return (double) sum /count;
    }

}
