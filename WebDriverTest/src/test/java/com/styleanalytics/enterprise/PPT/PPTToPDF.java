package com.styleanalytics.enterprise.PPT;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import org.apache.poi.xslf.usermodel.*;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import org.testng.annotations.Test;


public class PPTToPDF extends EnterpriseBaseClass {

    @Test
    public static void  test(String reportName, String reportTemplateName) throws IOException{

        String snapshotDate =property("LabsSnapshotDate");
        String pdfDownloadPath = property("PDFDownloadLocation");
        String pptExpectedLocation =  property("LabsPPTExpectedLocation");
        String pptFileLocation = property("CreatePDF");
        String file2 = pdfDownloadPath+reportName+"-"+snapshotDate+"-"+reportTemplateName+".pptx";


        //creating an empty presentation
        File file=new File(file2);
        XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(file));


        //getting the dimensions and size of the slide

        Dimension pgsize = ppt.getPageSize();
        List<XSLFSlide> slide = ppt.getSlides();
        BufferedImage img=null;
        Document doc=new Document();
        try {
            PdfWriter.getInstance(doc, new  FileOutputStream(pptFileLocation+"PPTImages.pdf"));

            doc.open();

            for (int i = 0; i < slide.size(); i++) {
                img = new BufferedImage(pgsize.width, pgsize.height,BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics = img.createGraphics();

                //clear the drawing area
                graphics.setPaint(Color.white);
                graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));

                //render
                slide.get(i).draw(graphics);
                FileOutputStream out = new FileOutputStream(pptFileLocation+i+".png");
                javax.imageio.ImageIO.write(img, "png", out);
                ppt.write(out);
                com.itextpdf.text.Image image =com.itextpdf.text.Image.getInstance(pptExpectedLocation+i+".png");
                doc.setPageSize(new com.itextpdf.text.Rectangle(image.getScaledWidth(), image.getScaledHeight()));
                doc.newPage();
                image.setAbsolutePosition(0, 0);
                doc.add(image);

                System.out.println("Image successfully created");
                out.close();
            }
            doc.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


}
