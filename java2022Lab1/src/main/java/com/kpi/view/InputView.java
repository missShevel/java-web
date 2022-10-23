package com.kpi.view;
import java.io.File;
import java.util.Scanner;

public class InputView {

    public boolean inputValidator(String dirPath) {
        File file = new File(dirPath);
        return file.exists() && file.isDirectory();
    }

    public String getFolderName(){
        System.out.print( "Type pathname: ");
        Scanner scan = new Scanner(System.in);
        String fileName = scan.nextLine();
        return fileName;
    }

}

