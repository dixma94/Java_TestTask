package org.example.Statistics;

import java.math.BigDecimal;

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
        System.out.println("Integers full statistics:"+ "\n"
                +"count:\t\t"+ count + "\n"
                +"max:\t\t" +max +"\n"
                +"min:\t\t"+ min+"\n"
                +"sum:\t\t" + sum +"\n"
                +"average:\t" + new BigDecimal(GetAverage()).toPlainString() );
        System.out.println();
    }
    private double GetAverage(){
        return (double) sum /count;
    }

}
