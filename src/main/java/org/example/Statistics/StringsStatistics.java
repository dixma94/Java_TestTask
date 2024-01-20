package org.example.Statistics;

// Статистику делаем дженериком, наследуем конкретные реализации от дженерика
// public class StringProperty extends Property<String> {


public class StringsStatistics implements IStatistics<String> {
    private  int max = 0;
    private  int min = Integer.MAX_VALUE;
    private int count = 0;
    public void AddValue(String string){
        if(string.isEmpty()) return;
        if (string.length()>max) max = string.length();
        if (string.length()<min) min = string.length();
        count++;
    }
    public void PrintShortStatistic(){
        if (count==0) return;
        System.out.println("Strings count: "+ count);
    }
    public void PrintFullStatistic(){
        if (count==0) return;
        System.out.println("Strings full statistics:"+ "\n"
                +"count:\t\t"+ count + "\n"
                +"max length:\t" +max +"\n"
                +"min length:\t"+ min);
        System.out.println();

    }
}
