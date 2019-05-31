package com.styleanalytics.enterprise.PPT;


import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.xmlbeans.XmlException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadPPT {


    public void readFirst() throws IOException, XmlException {

        File file = new File("example1.pptx");
        FileInputStream inputstream = new FileInputStream(file);
        XMLSlideShow ppt = new XMLSlideShow(inputstream);

    }
}
