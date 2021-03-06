package com.kantar.sessionsjob;

public class Main {
    // See README.txt for usage example
    public static void main(String[] args)
    {
        if (args.length < 2) {
            System.err.println("Missing arguments: <input-statements-file> <output-sessions-file>");
            System.exit(1);
        }
        // TODO: write application ...
        FileManager fileManager = new FileManager(args[0],args[1]);
        DataManager dataManager = new DataManager();
        fileManager.writeToFile(dataManager.prepare(fileManager.getCollectionOfHomeModelsList()));
    }
}
