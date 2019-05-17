package com.test.demo;

import com.itextpdf.text.pdf.PdfReader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

public class PdfToPngDemo {

    /**
     * pdf转换PNG
     * @param pdfFilePath       PDF路径
     * @param dstImgFolder      最终图片输出路径
     * @throws IOException
     */
    public static void pdf2Image(String pdfFilePath,String dstImgFolder) throws IOException {

        File file = new File(pdfFilePath);

        PDDocument pdDocument;

        String imgFolderPath = null;

        pdDocument = PDDocument.load(file);

        PDFRenderer renderer = new PDFRenderer(pdDocument);

        PdfReader reader = new PdfReader(pdfFilePath);

        int pages = reader.getNumberOfPages();

        for (int i=0;i<pages;i++){
            File dstFile = new File("D:\\pdf\\temp\\"+i+".png");

            BufferedImage bufferedImage = renderer.renderImageWithDPI(i,1);

            ImageIO.write(bufferedImage,"png",dstFile);
            bufferedImage.flush();
        }
    }

    public static void main(String[] args) throws IOException {

        pdf2Image("D:\\pdf\\temp\\test66.pdf","D:\\pdf\\temp");

    }

}
