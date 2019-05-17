package com.test.demo;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDemo1 {

    public static void main(String[] args) throws Exception {

        Document document = new Document(PageSize.A4);

        int i = (int) (Math.random()*100);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\pdf\\a" + i + ".pdf"));
        document.open();

        String srcFile = "D:\\pdf\\test89.pdf";
        String destFile = "D:\\pdf\\test10.pdf";
        String imgPath = "E:\\workspace\\itextDemo\\src\\main\\resources\\8.png";

        //设置字体
        BaseFont baseFont = BaseFont.createFont("E:\\workspace\\itextDemo\\src\\main\\resources\\typeface\\simsun.ttf",BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

        Font fontTitle = new Font(baseFont,16);
        Font fontText = new Font(baseFont,12);
        Font font6 = new Font(baseFont,8);



        PdfPTable table = new PdfPTable(3);

        table.setTotalWidth(100);

        table.setWidths(new int[]{30,40,30});

        //第一列
        PdfPCell cell = new PdfPCell();
        Paragraph paragraph = new Paragraph();
        paragraph.setFont(fontTitle);
        Phrase phrase = new Phrase("员工行程导出");
        paragraph.add(phrase);
        cell.addElement(paragraph);
        cell.disableBorderSide(13);
        cell.setFixedHeight(30);
        table.addCell(cell);

        //第二列
        PdfPCell cell2 = new PdfPCell();
        Paragraph paragraph2 = new Paragraph();
        paragraph2.setAlignment(Element.ALIGN_LEFT);
        paragraph2.setFont(fontText);
        Phrase phrase2 = new Phrase("上海在途网路科技有限公司");
        paragraph2.add(phrase2);
        cell2.addElement(paragraph2);
        cell2.setFixedHeight(30);
        cell2.disableBorderSide(13);
        table.addCell(cell2);


        //第三列
        PdfPCell cell3 = new PdfPCell();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Paragraph paragraph3 = new Paragraph("" + simpleDateFormat.format(date));
        paragraph3.setAlignment(Element.ALIGN_RIGHT);
        cell3.addElement(paragraph3);
        cell3.setFixedHeight(30);
        cell3.disableBorderSide(13);
        table.addCell(cell3);






        PdfPTable table1 = new PdfPTable(2);
        table1.setTotalWidth(100);
        table1.setWidths(new int[]{10,90});

        //第一列
        PdfPCell cell4 = new PdfPCell();
        Paragraph paragraph4 = new Paragraph();
        paragraph4.setFont(fontText);
        Phrase phrase4 = new Phrase("张三");
        paragraph4.add(phrase4);
        cell4.disableBorderSide(15);
        cell4.addElement(paragraph4);

        table1.addCell(cell4);

        //第二列
        PdfPCell cell5 = new PdfPCell();
        Paragraph paragraph5 = new Paragraph();
        Font font5 = new Font(baseFont,10);
        paragraph5.setFont(font5);
        Phrase phrase5 = new Phrase("上海在途网路科技有限公司 - 研发中心 - 技术部 - 产品部");
        paragraph5.add(phrase5);
        cell5.disableBorderSide(15);
        cell5.addElement(paragraph5);

        table1.addCell(cell5);


        //第三 部分
        PdfPTable table2 = new PdfPTable(1);
        table2.setTotalWidth(100);
        PdfPCell cell6 = new PdfPCell();
        Paragraph paragraph1 = new Paragraph();
        Date date1 = new Date();
        Phrase phrase1 = new Phrase("行程时间：" + simpleDateFormat.format(date1) + "-" + simpleDateFormat.format(date));
        paragraph1.setFont(font5);
        paragraph1.add(phrase1);
        cell6.addElement(paragraph1);
        cell6.disableBorderSide(15);
        cell6.setFixedHeight(50);
        table2.addCell(cell6);


        //正文部分
        PdfPTable table3 = new PdfPTable(3);

        table3.setTotalWidth(100);
        table3.setWidths(new int[]{20,10,70});

        //第一列
        PdfPCell cell7 = new PdfPCell();
        cell7.setFixedHeight(25);
        Paragraph paragraph7 = new Paragraph();
        paragraph7.setFont(fontText);
        Phrase phrase7 = new Phrase(simpleDateFormat.format(date));
        paragraph7.add(phrase7);
        cell7.setUseAscender(true);
        cell7.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell7.disableBorderSide(15);
        cell7.addElement(paragraph7);

        table3.addCell(cell7);


        //第二列  --中间图片
        PdfPCell cell8 = new PdfPCell();
        cell8.setFixedHeight(25);

        Image image = Image.getInstance("E:\\workspace\\itextDemo\\src\\main\\resources\\2.png");

        image.scaleAbsolute(10,10);
        image.setAbsolutePosition(10,10);

        cell8.addElement(image);
        cell8.setUseAscender(true);
        cell8.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell8.disableBorderSide(15);
        table3.addCell(cell8);


        //第三列  --正文内容
        PdfPCell cell9 = new PdfPCell();
        cell9.disableBorderSide(15);
        cell9.setFixedHeight(25);
        cell9.setBackgroundColor(new BaseColor(215,215,215));

        PdfPTable table4 = new PdfPTable(3);
        table4.setTotalWidth(100);
        table4.setWidths(new int[]{10,20,30});

        PdfPCell cell9_1 = new PdfPCell();
        Paragraph paragraph9_1 = new Paragraph();
        paragraph9_1.setFont(fontText);
        Phrase phrase9_1 = new Phrase("机票");
        paragraph9_1.add(phrase9_1);
        cell9_1.disableBorderSide(15);
        cell9_1.setFixedHeight(40);
        cell9_1.addElement(paragraph9_1);
        cell9_1.setUseAscender(true);
        cell9_1.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        cell9_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table4.addCell(cell9_1);

        PdfPCell cell9_2 = new PdfPCell();
        Paragraph paragraph9_2 = new Paragraph();
        paragraph9_2.setFont(fontText);
        Phrase phrase9_2 = new Phrase("上海-北京");
        paragraph9_2.add(phrase9_2);
        cell9_2.disableBorderSide(15);
        cell9_2.setFixedHeight(40);
        cell9_2.addElement(paragraph9_2);
        cell9_2.setUseAscender(true);
        cell9_2.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        cell9_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table4.addCell(cell9_2);

        PdfPCell cell9_3 = new PdfPCell();
        Paragraph paragraph9_3 = new Paragraph();
        paragraph9_3.setFont(font5);
        Phrase phrase9_3 = new Phrase("MU3134 经济舱");
        paragraph9_3.add(phrase9_3);
        cell9_3.disableBorderSide(15);
        cell9_3.setFixedHeight(40);
        cell9_3.addElement(paragraph9_3);
        cell9_3.setUseAscender(true);
        cell9_3.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        cell9_3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table4.addCell(cell9_3);

        cell9.addElement(table4);

        table3.addCell(cell9);

        //addPdfImgMark(writer,srcFile,destFile,imgPath,200,400);




        PdfLayer layer = new PdfLayer("layerName1",writer);


        PdfReader reader = new PdfReader(srcFile,"PDF".getBytes());
        PdfStamper stamper = new PdfStamper(reader,new FileOutputStream(new File(destFile)));

        PdfContentByte under;
        PdfGState gState = new PdfGState();

        Image img = Image.getInstance(imgPath);

        //坐标
        img.setAbsolutePosition(200,400);

        img.setRotation(-20);

        img.setRotation(45);

        int pageSize = reader.getNumberOfPages();//原PDF文件的总页数
        for(int j=1;j<=pageSize;j++){
            under = stamper.getUnderContent(j);
            under.setGState(gState);
            under.addImage(img);
        }
        stamper.close();

        document.close();


    }

   /* public static String markLocalImage42Dist(String srcPdf, String distPdf, List<String> layerPathArr)
            throws IOException, DocumentException {
        File srcPdfFile = new File(srcPdf);
        if (!srcPdfFile.exists()) {
            throw new IllegalArgumentException("找不到需要添加图层的pdf文件");
        }

        PdfReader reader = new PdfReader(srcPdf);
        int n = reader.getNumberOfPages(); // PDF页数

        PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(distPdf));
        PdfContentByte over;

        for (String layerPath : layerPathArr) {
            File layerFile = new File(layerPath);
            String currentPageNo = layerFile.getName().substring(0, layerFile.getName().lastIndexOf(".")); // 图片名称(对应页数)

            boolean isNum = currentPageNo.matches("[0-9]+");
            if (!isNum) {
                throw new IllegalArgumentException("图层名称是不是数字");
            }

            Image img = Image.getInstance(layerPath);
            img.setAbsolutePosition(0, 0);
            if (n > 0 && n >= Integer.parseInt(currentPageNo)) {
                over = stamp.getOverContent(Integer.parseInt(currentPageNo));
                over.addImage(img);
            }
        }
        stamp.close();
        reader.close();
        return distPdf;
    }*/





}
