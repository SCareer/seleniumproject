package com.styleanalytics.enterprise.PPT;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;


import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.PDF.PDFFilesMerge;
import com.styleanalytics.enterprise.PDF.PDFTest;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;
import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.PDF.PDFFilesMerge;
import com.styleanalytics.enterprise.PDF.PDFTest;
import org.apache.poi.hslf.model.Slide;
import org.apache.poi.hslf.usermodel.SlideShow;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PPTToPDFConverter extends EnterpriseBaseClass {

    @Test
    public void pptToPDFConverter() throws IOException, DocumentException, com.itextpdf.text.DocumentException {

        //load any ppt file
        FileInputStream inputStream = new FileInputStream("C:\\Users\\viswanath.STYLEDOMAIN\\Downloads\\Scenario for Labs Automation-20160531-Before and After PowerPoint (100).ppt");
        SlideShow ppt = new SlideShow(inputStream);
        inputStream.close();
        Dimension pgsize = ppt.getPageSize();

        double zoom = 2; // magnify it by 2
        AffineTransform at = new AffineTransform();
        at.setToScale(zoom, zoom);



        for(int i=0;i<ppt.getSlides().length;i++) {

            //take first slide and save it as an image
            Slide slide = ppt.getSlides()[i];
            BufferedImage img = new BufferedImage(pgsize.width, pgsize.height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = img.createGraphics();
            graphics.setPaint(Color.white);
            graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width,
                    pgsize.height));
            slide.draw(graphics);
            FileOutputStream out = new FileOutputStream("C:\\Selenium\\Build Outputs\\CreatePDF\\slideImage" + i + ".png");
            javax.imageio.ImageIO.write(img, "png", out);
            out.close();


            //get saved slide-image and save it into pdf
            Image slideImage = Image.getInstance("C:\\Selenium\\Build Outputs\\CreatePDF\\slideImage"+ i + ".png");
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Selenium\\Build Outputs\\CreatePDF\\PPTtoImageTest"+i+".pdf"));
            document.setPageSize(new Rectangle(slideImage.getWidth(), slideImage.getHeight()));
            document.open();
            slideImage.setAbsolutePosition(0, 0);
            document.add(slideImage);
            document.close();
        }

        //Merge PDF's

        PDFFilesMerge.mergePDF("C:\\Selenium\\Build Outputs\\CreatePDF","MergedFile.PDF");


    }

    public static void pptToPDFConverter(String pptFilePath) throws IOException, DocumentException, com.itextpdf.text.DocumentException {


        String pdfCreateFolder = property("CreatePDF");

        File file = new File(pptFilePath);
        FileInputStream inputstream = new FileInputStream(file);
        XMLSlideShow ppt = new XMLSlideShow(inputstream);

        //load any ppt file

      /*  FileInputStream inputStream = new FileInputStream(pptFilePath);
        SlideShow ppt = new SlideShow(inputStream);
        inputStream.close();*/
        //Dimension pgsize = ppt.getPageSize();

        Dimension pgsize = ppt.getPageSize();
        List<XSLFSlide> slide = ppt.getSlides();
        //BufferedImage img=null;

        double zoom = 2; // magnify it by 2
        AffineTransform at = new AffineTransform();
        at.setToScale(zoom, zoom);



        for(int i=0;i<slide.size();i++) {

            //take first slide and save it as an image

           // XSLFSlide slide = ppt.getSlideMasters().get(i);

            //XSLFSlide slide = ppt.getSlideMasters()[i]

           // Slide slide = ppt.getSlideMasters().
            BufferedImage img = new BufferedImage(pgsize.width, pgsize.height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = img.createGraphics();
            graphics.setPaint(Color.white);
            graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width,
                    pgsize.height));
            slide.get(i).draw(graphics);
            FileOutputStream out = new FileOutputStream(pdfCreateFolder+"slideImage" + i + ".png");
            javax.imageio.ImageIO.write(img, "png", out);
            out.close();


            //get saved slide-image and save it into pdf
            Image slideImage = Image.getInstance(pdfCreateFolder+"slideImage"+ i + ".png");
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfCreateFolder+"PPTtoImageTest"+i+".pdf"));
            document.setPageSize(new Rectangle(slideImage.getWidth(), slideImage.getHeight()));
            document.open();
            slideImage.setAbsolutePosition(0, 0);
            document.add(slideImage);
            document.close();
        }

        //Merge PDF's

        PDFFilesMerge.mergePDF(pdfCreateFolder,"MergedFile.PDF");


    }



@Test
    public void compareT() throws IOException {


        PDFTest pdfTest = new PDFTest();

        String file1 = "C:\\Selenium\\Build Outputs\\CreatePDF\\MergedFile1.PDF";
        String file2 = "C:\\Selenium\\Build Outputs\\CreatePDF\\MergedFile.PDF";

        pdfTest.comparePDF(file1,file2);
    }

    @Test
    public void pptToImageConverter() throws IOException {

        //creating an empty presentation
        FileInputStream inputStream = new FileInputStream("C:\\Users\\viswanath.STYLEDOMAIN\\Downloads\\Scenario for Labs Automation-20160531-Before and After PowerPoint (100).ppt");
        SlideShow ppt = new SlideShow(inputStream);
        inputStream.close();

        //getting the dimensions and size of the slide
        Dimension pgsize = ppt.getPageSize();
        Slide[] slide = ppt.getSlides();

        for (int i = 0; i < slide.length; i++) {
            BufferedImage img = new BufferedImage(pgsize.width, pgsize.height, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = img.createGraphics();

            //clear the drawing area
            graphics.setPaint(Color.white);
            graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));

            //render


            //creating an image file as output
            FileOutputStream out = new FileOutputStream("C:\\Users\\viswanath.STYLEDOMAIN\\Downloads\\ppt_image_" + i + ".png");
            javax.imageio.ImageIO.write(img, "png", out);
            System.out.println("Image successfully created");
            out.close();


        }
    }
}