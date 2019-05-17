package com.test.demo;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class WaterMarkImage extends PdfPageEventHelper {

    private String picPath = "";

    public String getPicPath(){
        return picPath;
    }
    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public WaterMarkImage() {
    }

    public WaterMarkImage(String picPath) {
        this.picPath = picPath;
    }


    @Override
    public void onStartPage(PdfWriter writer, Document document) {
        //MyDemo.mark(document.,originalFile,tempFile,0f,0f);
    }
}
