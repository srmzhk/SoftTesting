package io;
import java.io.*;
import java.util.Scanner;

public class StructureToFile {
    public static void writeStructureToFile(String inputPath) {
        String outputPath = "output.txt";
        try {
            FileWriter writer = new FileWriter(outputPath);
            if(inputPath.contains(".txt"))
                readFileAndCalcParams(inputPath, writer);
            else
                exploreFolder(inputPath, writer, "");
            writer.close();
            System.out.println("Successful write into " + outputPath);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void exploreFolder(String folderPath, FileWriter writer, String indent) throws IOException {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        int i = -1;
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    writer.write(indent + "+-- " + file.getName() + "\\" + "\n");
                    exploreFolder(file.getAbsolutePath(), writer, indent + "|   ");
                } else {
                    writer.write(indent + " " + ++i + " " + file.getName() + "\n");
                }
            }
        }
    }

    private static void readFileAndCalcParams(String filePath, FileWriter writer) throws IOException {
        int fouldersCounter = 0;
        int filesCounter = 0;
        int filesLengths = 0;
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String str = scanner.nextLine();
                if(str.contains("\\"))
                    fouldersCounter++;
                else{
                    filesCounter++;
                    int startNameIndex = -1;
                    for(int i = 0; i < 10; i++){
                        if(str.contains(i + " ")){
                            startNameIndex = i + 2;
                            break;
                        }
                    }
                    filesLengths += str.length() - startNameIndex;
                }
            }
        } catch (Exception e) {
            System.out.println("Smth goes wrong...");
        }
        finally {
            System.out.println("Folders amount: " + fouldersCounter);
            System.out.println("Files amount: " + filesCounter);
            System.out.println("Avg amount of files in foulder: " + (double)filesCounter / (double)fouldersCounter);
            System.out.println("Avg length of files: " + (double)filesLengths / (double)filesCounter);
        }
    }
}
