package org.example.OptionsDir;

import org.example.Statistics.PrintStatisticsMode;

import java.io.File;
import java.util.*;

public class Options {
    public  boolean IsAppend;
    public PrintStatisticsMode statisticsMode = PrintStatisticsMode.NO_STATISTICS;
    public  List<String> listInputFilePaths = new ArrayList<>();
    private String outputPath = "";
    private String prefixPath = "";
    private Map<String, OptionAction> optionsMap = new HashMap<>();

    public Options(String[] args) throws Exception{
        CreateOptionsMap();
        ParseOptions(args);
    }

    private void CreateOptionsMap() {

        optionsMap.put("-s",new OptionAction("print short statistics",
                false,
                (parameter) -> statisticsMode= (statisticsMode == PrintStatisticsMode.FULL_STATISTICS)?PrintStatisticsMode.FULL_STATISTICS:PrintStatisticsMode.SHORT_STATISTICS)
        );
        optionsMap.put("-f",new OptionAction("print full statistics",false,(parameter)-> statisticsMode = PrintStatisticsMode.FULL_STATISTICS));
        optionsMap.put("-a",new OptionAction("append to files",false,(parameter)->IsAppend = true));
        optionsMap.put("-p",new OptionAction("prefix output file",true, parameter-> prefixPath = parameter));
        optionsMap.put("-o", new OptionAction("path output file",true, parameter-> {
            new File(parameter).mkdirs();
            outputPath =  parameter +"\\";
        }));
    }

    public void ParseOptions(String[] args) throws Exception {
        System.out.println("Filter files with next options:");
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (optionsMap.containsKey(arg)){
                OptionAction option = optionsMap.get(arg);
                if (option.hasParameter) {
                    if (i>=args.length-1) break;
                    option.operation.Operate(args[i+1]);
                    System.out.println(arg+ "("+option.optionName + ")\t" + args[i+1]);
                    i++;
                }
                else {
                    option.operation.Operate("");
                    System.out.println(arg+ "("+option.optionName + ")\t" + "True");
                }
            }
            else if (arg.charAt(0)=='-'){
                System.out.println("Undefined option:\t" + arg);
            }
            else listInputFilePaths.add(arg);
        }
        if(listInputFilePaths.isEmpty()) {
            throw new Exception("Missing input files or input files come after the Prefix, Output option");
        } else{
            String text = "Input files:\t";
            for(String path: listInputFilePaths){
              text=text.concat(path).concat(" ");
            }
            System.out.println(text);
        }
        System.out.println();
    }

    public String GetOutputPath() {
        return outputPath + prefixPath;
    }


}


