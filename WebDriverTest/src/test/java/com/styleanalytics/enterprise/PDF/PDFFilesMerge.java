package com.styleanalytics.enterprise.PDF;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSmartCopy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

public class PDFFilesMerge {

    public static void mergePDF(String directory, String targetFile) throws DocumentException, IOException, com.itextpdf.text.DocumentException {
        File dir = new File(directory);
        File[] filesToMerge = dir.listFiles(new FilenameFilter() {
            public boolean accept(File file, String fileName) {
                //System.out.println(fileName);
                return fileName.endsWith(".pdf");
            }
        });
        Document document = new Document();
        FileOutputStream outputStream = new FileOutputStream(directory+targetFile);
        PdfCopy copy = new PdfSmartCopy(document, outputStream);
        document.open();

        for (File inFile : filesToMerge) {
            System.out.println(inFile.getCanonicalPath());
            PdfReader reader = new PdfReader(inFile.getCanonicalPath());
            copy.addDocument(reader);
            reader.close();
        }
        document.close();
    }
}
