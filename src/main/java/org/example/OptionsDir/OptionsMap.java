package org.example.OptionsDir;

import org.example.Statistics.PrintStatisticsMode;

import java.io.File;
import java.util.HashMap;
public class OptionsMap extends HashMap<String, OptionAction> {
    public OptionsMap(Options options){
        this.put("-s",new OptionAction("print short statistics",
                false,
                (parameter) -> options.setStatisticsMode(
                        (options.getStatisticsMode() == PrintStatisticsMode.FULL_STATISTICS)?
                                PrintStatisticsMode.FULL_STATISTICS:
                                PrintStatisticsMode.SHORT_STATISTICS))
        );
        this.put("-f",new OptionAction("print full statistics",false,(parameter)-> options.setStatisticsMode(PrintStatisticsMode.FULL_STATISTICS)));
        this.put("-a",new OptionAction("append to files",false,(parameter)-> options.setAppend(true)));
        this.put("-p",new OptionAction("prefix output file",true, options::setPrefixPath));
        this.put("-o", new OptionAction("path output file",true, parameter-> {
            new File(parameter).mkdirs();
            options.setOutputPath(parameter +"\\");
        }));
    }
}
