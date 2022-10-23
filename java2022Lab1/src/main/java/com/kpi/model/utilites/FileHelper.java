package com.kpi.model.utilites;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;


public class FileHelper {

    private static String deleteLexems(String input) {
        return Arrays.stream(input.split("\s+"))
                .filter(w -> !(3 <= w.length() && w.length() <= 5))
                .collect(Collectors.joining(" "));
    }
    public static String readContent(String fileName) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        return content;
    }

    public static void changeFile(String path) throws IOException {
        String content = deleteLexems(readContent(path));
        FileWriter printWriter = new FileWriter(path, false);
        printWriter.write(content);
        printWriter.close();
        System.out.println(path);
    }
}