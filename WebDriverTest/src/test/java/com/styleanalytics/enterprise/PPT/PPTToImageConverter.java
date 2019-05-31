package com.styleanalytics.enterprise.PPT;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hslf.model.Slide;
import org.apache.poi.hslf.usermodel.SlideShow;


public class PPTToImageConverter {

   private static BufferedImage img;

    public static void main(String args[]) throws IOException {

        //creating an empty presentation
        FileInputStream inputStream = new FileInputStream("C:\\Users\\viswanath.STYLEDOMAIN\\Downloads\\Scenario for Labs Automation-20160531-Before and After PowerPoint (100).ppt");
        SlideShow ppt = new SlideShow(inputStream);
        inputStream.close();

        //getting the dimensions and size of the slide
        Dimension pgsize = ppt.getPageSize();
        Slide[] slide = ppt.getSlides();

        for (int i = 0; i < slide.length; i++) {
            img = new BufferedImage(
                    pgsize.width, pgsize.height, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = img.createGraphics();

            //clear the drawing area
            graphics.setPaint(Color.white);
            graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));

            //render
            slide[i].draw(graphics);


            //creating an image file as output
            FileOutputStream out = new FileOutputStream("C:\\Users\\viswanath.STYLEDOMAIN\\Downloads\\ppt_image"+i+".png");
            javax.imageio.ImageIO.write(img, "png", out);
            ppt.write(out);
            out.close();

        }

        System.out.println("Image successfully created");

    }
}