package com.kantar.sessionsjob;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileManager
{
    private final String inputFilePath;
    private final String outputFilePath;

    public FileManager(String inputFilePath, String outputFilePath)
    {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
    }

    public Collection<List<HomeModel>> getCollectionOfHomeModelsList(){
        Map<String, List<HomeModel>> homes;
        try(Stream<String> lines = Files.lines(Paths.get(inputFilePath))){
            homes = lines.skip(1)
                    .map(line -> line.split("\\|"))
                    .map(item -> new HomeModel(item[0], item[1], item[2], item[3]))
                    .collect(Collectors.groupingBy(HomeModel::getHomeNo, LinkedHashMap::new, Collectors.toList()));
            return homes.values();
        }
        catch (IOException e)
        {
            System.err.println("Could not read the file: " + e);
        }
        return Collections.emptyList();
    }
    public void writeToFile(List<HomeModel> handler){
        try (FileWriter writer = new FileWriter(outputFilePath))
        {
            String output = "HomeNo|Channel|Starttime|Activity|EndTime|Duration\n";
            output += handler.stream()
                    .map(HomeModel::toPsVRow)
                    .collect(Collectors.joining("\n"));
            writer.write(output);
        }
        catch (IOException e)
        {
            System.err.println("Could not write the file: " + e);
        }
    }
}
