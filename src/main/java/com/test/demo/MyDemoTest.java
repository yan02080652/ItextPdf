package com.test.demo;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyDemoTest {

    public static void export(List<TravelPlanOrderCommon> commons) throws IOException, DocumentException {

        //上下左右边距 ， 和纸张大小
        Document document = new Document(PageSize.A4);

        int i = (int) (Math.random()*100);
        String originalFile = "D:\\pdf\\test"+i+".pdf";
        String tempFile = "D:\\pdf\\temp\\test"+i+".pdf";
        String imgPath = "E:\\workspace\\itextDemo\\src\\main\\resources\\1.gif";
        //String imgPath2 = "E:\\workspace\\itextDemo\\src\\main\\resources\\waterMark2.png";
        Image image7 = Image.getInstance("E:\\workspace\\itextDemo\\src\\main\\resources\\7.png");
        List<String> list1 = new ArrayList<String>();

        list1.add(imgPath);

        PdfWriter pdfWriter = null;
        //设置图片透明度
        //transparentImage(imgPath,imgPath2,3,"png");
        try {
            //将 文件写入到地址
            pdfWriter =PdfWriter.getInstance(document, new FileOutputStream("D:\\pdf\\test" + i + ".pdf"));

            //设置字体
            BaseFont baseFont = BaseFont.createFont("E:\\workspace\\itextDemo\\src\\main\\resources\\typeface\\simsun.ttf",BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

            Font fontTitle = new Font(baseFont,16);
            Font fontText = new Font(baseFont,12);
            Font font6 = new Font(baseFont,8);
            setFooter(pdfWriter,baseFont,10,PageSize.A4);

            //打开文本
            document.open();

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

            List<Model> list = new ArrayList<Model>();

            for (int y=0;y<20;y++){

                Model model = new Model("火车"+y,"上海-北京"+y,"MU8989 商务舱",new Date());
                list.add(model);

            }

            document.add(table);
            document.add(table1);
            document.add(table2);

            for (int k=0;k<list.size();k++){

                //正文部分
                PdfPTable table5 = new PdfPTable(3);

                table5.setTotalWidth(100);
                table5.setWidths(new int[]{20,10,70});

                //第一列
                PdfPCell cell10 = new PdfPCell();
                cell10.setFixedHeight(25);
                Paragraph paragraph10 = new Paragraph();
                paragraph10.setFont(fontText);
                Phrase phrase10 = new Phrase(simpleDateFormat.format(list.get(k).getDate()));
                paragraph10.add(phrase10);
                cell10.disableBorderSide(15);
                cell10.setUseAscender(true);
                cell10.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
                cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell10.addElement(paragraph10);

                table5.addCell(cell10);


                //第二列  --中间图片
                PdfPCell cell11 = new PdfPCell();
                cell11.setFixedHeight(25);
                Image image = Image.getInstance("E:\\workspace\\itextDemo\\src\\main\\resources\\2.png");
                image.scaleAbsolute(10,10);
                image.setAbsolutePosition(10,10);
                cell11.addElement(image);
                cell11.setUseAscender(true);
                cell11.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
                cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell11.disableBorderSide(15);
                table5.addCell(cell11);



                //第三列  --正文内容
                PdfPCell cell12 = new PdfPCell();
                cell12.setFixedHeight(25);
                cell12.disableBorderSide(15);
                cell12.setBackgroundColor(new BaseColor(215, 215, 215));

                PdfPTable table6 = new PdfPTable(3);
                table6.setTotalWidth(100);
                table6.setWidths(new int[]{15,25,40});

                    PdfPCell cell12_1 = new PdfPCell();
                    Paragraph paragraph12_1 = new Paragraph();
                    paragraph12_1.setFont(fontText);
                    Phrase phrase12_1 = new Phrase(list.get(k).getType());
                    paragraph12_1.add(phrase12_1);
                    cell12_1.disableBorderSide(15);
                    cell12_1.setFixedHeight(40);
                    cell12_1.addElement(paragraph12_1);
                    cell12_1.setUseAscender(true);
                    cell12_1.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
                    cell12_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    table6.addCell(cell12_1);

                    PdfPCell cell12_2 = new PdfPCell();
                    Paragraph paragraph12_2 = new Paragraph();
                    paragraph12_2.setFont(fontText);
                    Phrase phrase12_2 = new Phrase(list.get(k).getCity());
                    paragraph12_2.add(phrase12_2);
                    cell12_2.disableBorderSide(15);
                    cell12_2.setFixedHeight(40);
                    cell12_2.addElement(paragraph12_2);
                    cell12_2.setUseAscender(true);
                    cell12_2.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
                    cell12_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    table6.addCell(cell12_2);

                    PdfPCell cell12_3 = new PdfPCell();
                    Paragraph paragraph12_3 = new Paragraph();
                    paragraph12_3.setFont(font5);
                    Phrase phrase12_3 = new Phrase(list.get(k).getCode());
                    paragraph12_3.add(phrase12_3);
                    cell12_3.disableBorderSide(15);
                    cell12_3.setFixedHeight(40);
                    cell12_3.addElement(paragraph12_3);
                    cell12_3.setUseAscender(true);
                    cell12_3.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
                    cell12_3.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    table6.addCell(cell12_3);

                cell12.addElement(table6);

                table5.addCell(cell12);

                document.add(table5);


                //下半部分内容
                PdfPTable table10 = new PdfPTable(3);
                table10.setWidths(new int[]{20,10,70});
                PdfPCell cell15_1 = new PdfPCell();

                cell15_1.setFixedHeight(40);
                Paragraph paragraph15_1 = new Paragraph();
                paragraph15_1.setFont(font5);
                //simpleDateFormat1 = new SimpleDateFormat("HH:mm:ss");
                //Phrase phrase15_1 = new Phrase(simpleDateFormat1.format(new Date()));
                //paragraph15_1.add(phrase15_1);
                cell15_1.setUseAscender(true);
                cell15_1.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
                cell15_1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell15_1.disableBorderSide(15);
                //cell15_1.addElement(paragraph7);

                table10.addCell(cell15_1);


                //第二列  --中间图片
                PdfPCell cell16_1 = new PdfPCell();
                cell16_1.setFixedHeight(40);

                image7.scaleAbsolute(10,10);
                image7.setAbsolutePosition(10,10);

                cell16_1.addElement(image7);
                cell16_1.setUseAscender(true);
                cell16_1.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
                cell16_1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell16_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell16_1.disableBorderSide(15);
                table10.addCell(cell16_1);


                //第三列 ， 详细内容
                PdfPCell cell17_1 = new PdfPCell();
                cell17_1.setFixedHeight(40);
                Paragraph paragraph17_1 = new Paragraph();
                cell17_1.disableBorderSide(15);
                Chunk chunk2_1 = new Chunk("金额：￥1234.35元     ");
                Chunk chunk2_2 = new Chunk("预定时间：2019-04-01    ");
                Chunk chunk2_3 = new Chunk("差旅计划号：201903030004    ");
                Chunk chunk2_4 = new Chunk("费用归属：技术部      ");
                Chunk chunk2_5 = new Chunk("订单号：000122201903030004    ");
                paragraph17_1.setFont(font6);
                paragraph17_1.add(chunk2_1);
                paragraph17_1.add(chunk2_2);
                paragraph17_1.add(chunk2_3);
                paragraph17_1.add(chunk2_4);
                paragraph17_1.add(chunk2_5);
                cell17_1.addElement(paragraph17_1);
                table10.addCell(cell17_1);

                document.add(table10);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        document.close();

        //Demo2.markLocalImage42Dist(originalFile,tempFile,list1);

    }

    public static void setFooter(PdfWriter writer, BaseFont bf, int presentFontSize, Rectangle pageSize){
        ItextPdfHeaderFooter headerFooter = new ItextPdfHeaderFooter(bf,presentFontSize,pageSize);
        writer.setPageEvent(headerFooter);
    }



}
