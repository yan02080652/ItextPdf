package com.test.demo;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;

public class PngDemo {

    /*
     * 实现pdf文件转换为png
     * 参数是第一个是要转的转换的是pdffile
     * 第二个参数是是要存储的png图片的路径
     */
    public static void pdfFileToImage(File pdffile,String targetPath){
        try {
            FileInputStream instream = new FileInputStream(pdffile);
            InputStream byteInputStream=null;
            try {
                PDDocument doc = PDDocument.load(instream);
                PDFRenderer renderer = new PDFRenderer(doc);
                int pageCount = doc.getNumberOfPages();
                //这里只能实现第一页的转换，如果有多页PDF则不能实现
                if (pageCount > 0) {
                    BufferedImage image = renderer.renderImage(0, 2.0f);
                    image.flush();
                    ByteArrayOutputStream bs = new ByteArrayOutputStream();
                    ImageOutputStream imOut;
                    imOut = ImageIO.createImageOutputStream(bs);
                    ImageIO.write(image, "png", imOut);
                    byteInputStream = new ByteArrayInputStream(bs.toByteArray());
                    byteInputStream.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            File uploadFile = new File(targetPath);
            FileOutputStream fops;
            fops = new FileOutputStream(uploadFile);
            fops.write(readInputStream(byteInputStream));
            fops.flush();
            fops.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }

    public static void main(String[] args) {
        File file =new File("D:\\pdf\\temp\\test66.pdf");
        //上传的是png格式的图片结尾
        String targetfile="D:\\pdf\\temp\\3.png";
        pdfFileToImage(file,targetfile);
    }

}
