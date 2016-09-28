package com.damily.damilyapp.utils;

import java.io.File;

/**
 * Created by Dandan.Cao on 2016/9/22.
 */
public class SaveTool {
    private String path = "/Sdcard/damily";

    public void WriteFile(String name) {
        File filePath = new File(path);
        if (!filePath.exists()) {
            filePath.mkdir();
        }
        String fileObject = filePath.getAbsolutePath() + name + ".txt";
        File fileName = new File(fileObject);
    }

    public void ReadFile() {


    }


}
