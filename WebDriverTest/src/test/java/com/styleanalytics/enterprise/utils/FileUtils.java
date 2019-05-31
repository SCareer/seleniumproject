package com.styleanalytics.enterprise.utils;

import java.io.File;

public class FileUtils {


    public static void deleteFilesWithSpecificExtension(String directory, String extension){

        File folder = new File(directory);
        File fList[] = folder.listFiles();

        for (File f : fList) {
            if (f.getName().endsWith(extension)) {
                f.delete();
            }}
    }
}
