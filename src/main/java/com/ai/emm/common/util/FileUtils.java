package com.ai.emm.common.util;

import java.io.File;

/**
 * Created by lenovo on 2017/1/4.
 */
public class FileUtils {
    public static void deleteAllFilesOfDir(File path) {
        if (path==null||!path.exists())
            return;
        if (path.isFile()) {
            path.delete();
            return;
        }
        File[] files = path.listFiles();
        for (int i = 0; i < files.length; i++) {
            deleteAllFilesOfDir(files[i]);
        }
        path.delete();
    }

    public static void deleteAllFilesOfDir(String path) {
        File file = new File(path);
        if (file==null||!file.exists())
            return;
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            deleteAllFilesOfDir(files[i]);
        }
        file.delete();
    }
}
