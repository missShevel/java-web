package com.kpi.controller;
import com.kpi.model.Solution;
import com.kpi.model.utilites.FileHelper;
import com.kpi.view.InputView;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class MainController {

    private final InputView input;
    private final FileHelper file;
    private Solution solution;

    public MainController() {
        this.input = new InputView();
        this.file=new FileHelper();
    }


        public void run() throws Exception {
        Solution solution;
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("Hello");
        String dirname;

        while (true) {
            dirname = input.getFolderName();
            if(input.inputValidator(dirname)) {
                if (!dirname.equals("/Users/user/Desktop/3 course/java-web/123")){
                    System.out.println("You can't change files in this directory (try: /Users/user/Desktop/3 course/java-web/123)");
                    continue;
                }
                break;
            } else {
                System.out.println("Wrong dirName try again: ");
            }
        }

        File folder = new File(dirname);
        solution = new Solution(dirname);

        solution.proseedFiles(folder,executorService);
        executorService.shutdown();

    }
}
