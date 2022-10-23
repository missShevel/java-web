package com.kpi.model;
import com.kpi.model.utilites.FileHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Solution {

    private final String dirPath;

    public Solution(String dirPath) {
        this.dirPath = dirPath;
    }



    public String proseedFiles(File file, ExecutorService executorService) throws Exception {
    String filename = file.getAbsolutePath();

    if (file.isDirectory()) {
        File[] allFiles = file.listFiles();

        List<Future<String>> allThrates = new ArrayList<>();
        for (var currentFile : allFiles) {
            Callable<String> runRecursion = () -> proseedFiles(currentFile,  executorService);
            Future<String> submit = executorService.submit(runRecursion);
            allThrates.add(submit);
        }
        String result = "";
        for (var task : allThrates) {
            result += task.get()+"/n" ;
        }
        return result;
    }
    if(file.getName().endsWith(".txt")) {
        FileHelper.changeFile(file.getAbsolutePath());
        return filename;
    }
        return "";
    }
}
