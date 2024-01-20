package org.example.OptionsDir;

import org.example.Statistics.PrintStatisticsMode;

import java.util.*;

public class Options {
    private boolean IsAppend;
    private PrintStatisticsMode statisticsMode = PrintStatisticsMode.NO_STATISTICS;
    private List<String> listInputFilePaths = new ArrayList<>();
    private String outputPath = "";
    private String prefixPath = "";

    public Options(String[] args) throws Exception{
        OptionsMap optionsMap = new OptionsMap(this);
        ParseOptions(args,optionsMap);
    }
    public void ParseOptions(String[] args, OptionsMap optionsMap) throws Exception {
        System.out.println("Filter files with next options:");
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if(!optionsMap.containsKey(arg) && arg.charAt(0)!='-') {
                getListInputFilePaths().add(arg);
                continue;
            }
            if(!optionsMap.containsKey(arg) && arg.charAt(0)=='-') {
                System.out.println("Undefined option:\t" + arg);
                continue;
            }
            OptionAction option = optionsMap.get(arg);
            if (!option.hasParameter) {
                option.operation.Operate("");
                System.out.println(arg + "("+ option.optionName + ")\t" + "True");
                continue;
            }
            if (i>=args.length-1){
                System.out.println("Option "+arg +" doesn't have a parameter. Specify option parameter.");
            }
            else {
                option.operation.Operate(args[i+1]);
                System.out.println(arg+ "("+option.optionName + ")\t" + args[i+1]);
                i++;
            }
        }
        PrintPathInputFiles();
        System.out.println();
    }
    public String GetOutputPath() {return outputPath + prefixPath;}
    private void PrintPathInputFiles() throws Exception {
        if(!getListInputFilePaths().isEmpty()) {
            String text = "Input files:\t";
            for(String path: getListInputFilePaths()){
                text=text.concat(path).concat(" ");
            }
            System.out.println(text);
        }
        else{
            throw new Exception("Missing input files or input files come after the Prefix, Output option");
        }
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public void setPrefixPath(String prefixPath) {
        this.prefixPath = prefixPath;
    }

    public boolean isAppend() {
        return IsAppend;
    }

    public void setAppend(boolean append) {
        IsAppend = append;
    }

    public PrintStatisticsMode getStatisticsMode() {
        return statisticsMode;
    }

    public void setStatisticsMode(PrintStatisticsMode statisticsMode) {
        this.statisticsMode = statisticsMode;
    }

    public List<String> getListInputFilePaths() {
        return listInputFilePaths;
    }

    public void setListInputFilePaths(List<String> listInputFilePaths) {
        this.listInputFilePaths = listInputFilePaths;
    }
}


