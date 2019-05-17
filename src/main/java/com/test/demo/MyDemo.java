package com.test.demo;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyDemo {

    public static void export(List<TravelPlanOrderCommon> commons,String orgName,String userName) throws IOException, DocumentException {

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
            //打开文本
            document.open();

            Font fontTitle = new Font(baseFont,16);
            Font fontText = new Font(baseFont,12);
            Font font10 = new Font(baseFont,10);
            Font font6_1 = new Font(baseFont,8);
            Font font6 = new Font(baseFont,8);
            Font font6_6 = new Font(baseFont,6);
            //setFooter(pdfWriter,baseFont,10,PageSize.A4);

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
            Phrase phrase2 = new Phrase(orgName);
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
            Phrase phrase4 = new Phrase(userName);
            paragraph4.add(phrase4);
            cell4.disableBorderSide(15);
            cell4.addElement(paragraph4);

            table1.addCell(cell4);

            //第二列
            PdfPCell cell5 = new PdfPCell();
            Paragraph paragraph5 = new Paragraph();
            Font font5 = new Font(baseFont,10);
            paragraph5.setFont(font5);
            Phrase phrase5 = new Phrase(orgName + "部门");
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
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy.mm.dd");
            Phrase phrase1 = new Phrase("行程时间：" + simpleDateFormat1.format(date1) + "-" + simpleDateFormat1.format(date));
            paragraph1.setFont(font5);
            paragraph1.add(phrase1);
            cell6.addElement(paragraph1);
            cell6.disableBorderSide(15);
            cell6.setFixedHeight(50);
            table2.addCell(cell6);

            document.add(table);
            document.add(table1);
            document.add(table2);

            for (int k=0;k<commons.size();k++){

                //正文部分
                PdfPTable table5 = new PdfPTable(5);

                table5.setTotalWidth(100);
                table5.setWidths(new int[]{20,10,10,25,35});

                //第一列
                PdfPCell cell10 = new PdfPCell();
                cell10.setFixedHeight(25);
                Paragraph paragraph10 = new Paragraph();
                paragraph10.setFont(font10);
                Phrase phrase10 = new Phrase(simpleDateFormat.format(commons.get(k).getTravelDate()));
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


                String temp = "";
                String tempImgPath = "";
                if (commons.get(k).getOrderType().equals("TRAIN")){
                    temp = "火车";
                    tempImgPath = "E:\\workspace\\itextDemo\\src\\main\\resources\\train.png";
                }else if (commons.get(k).getOrderType().equals("HOTEL")){
                    temp = "酒店";
                    tempImgPath = "E:\\workspace\\itextDemo\\src\\main\\resources\\hotel.png";
                }else if (commons.get(k).getOrderType().equals("AIRCRAFT")){
                    temp = "飞机";
                    tempImgPath = "E:\\workspace\\itextDemo\\src\\main\\resources\\aircraft.png";
                }


                //第三列  --小图片
                PdfPCell cell12 = new PdfPCell();
                cell12.setFixedHeight(25);
                Image image1 = Image.getInstance(tempImgPath);

                image1.scaleAbsolute(10,10);

                cell12.setImage(image1);
                cell12.setBackgroundColor(new BaseColor(215, 215, 215));
                cell12.disableBorderSide(15);
                table5.addCell(cell12);

                PdfPCell cell13 = new PdfPCell();
                cell13.setFixedHeight(25);
                Paragraph paragraph13 = new Paragraph();
                paragraph13.setFont(font10);
                Phrase phrase13_1 = new Phrase(temp + "     ");


                Phrase phrase13_2 = null;
                if (commons.get(k).getOrderType().equals("HOTEL")){
                    phrase13_2 = new Phrase(commons.get(k).getToCity() + "       ");
                }else{
                    phrase13_2 = new Phrase(commons.get(k).getFromCity() + "-" + commons.get(k).getToCity() + "  ");
                }
                String code = "";
                if (commons.get(k).getOrderType().equals("TRAIN")){
                    code = commons.get(k).getTrainCode();
                }else if (commons.get(k).getOrderType().equals("HOTEL")){
                    code = commons.get(k).getHotelName();
                }else if (commons.get(k).getOrderType().equals("AIRCRAFT")){
                    code = commons.get(k).getFlightNo();
                }
                Phrase phrase13_3 = new Phrase(code + "     ");

                paragraph13.add(phrase13_1);
                paragraph13.add(phrase13_2);

                cell13.addElement(paragraph13);
                cell13.setBackgroundColor(new BaseColor(215, 215, 215));
                cell13.disableBorderSide(15);
                cell13.setUseAscender(true);
                cell13.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
                cell13.setVerticalAlignment(Element.ALIGN_MIDDLE);

                table5.addCell(cell13);


                PdfPCell cell14 = new PdfPCell();
                cell14.setFixedHeight(25);
                Paragraph paragraph14 = new Paragraph();
                paragraph14.setFont(font6_1);
                paragraph14.add(phrase13_3);
                cell14.addElement(paragraph14);
                cell14.setBackgroundColor(new BaseColor(215, 215, 215));
                cell14.disableBorderSide(15);
                cell14.setUseAscender(true);
                cell14.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
                cell14.setVerticalAlignment(Element.ALIGN_MIDDLE);

                table5.addCell(cell14);

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
                Chunk chunk2_1 = new Chunk("金额：" + commons.get(k).getAmount() + "       ");
                Chunk chunk2_2 = new Chunk("预定时间：" + simpleDateFormat.format(commons.get(k).getBookingTime()) + "     ");
                Chunk chunk2_3 = null;
                if (commons.get(k).getTravelPlanNo()!=null && !commons.get(k).getTravelPlanNo().equals("")){
                    chunk2_3 = new Chunk("差旅计划号：" + commons.get(k).getTravelPlanNo() + "         ");
                }else{
                    chunk2_3 = new Chunk("无差旅计划                         ");
                }

                Chunk chunk2_4 = new Chunk("费用归属：" + commons.get(k).getCostCenterName() + "         ");
                Chunk chunk2_5 = new Chunk("订单号：" + commons.get(k).getOrderId() + "      ");
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

        //关闭文档，编辑结束
        document.close();

        //加水印
        markLocalImage42Dist(originalFile,tempFile,list1);

    }

    /**
     * @param writer    PdfWriter对象
     * @param bf        基础字体
     * @param presentFontSize   字体大小
     * @param pageSize  纸张大小
     */
    public static void setFooter(PdfWriter writer, BaseFont bf, int presentFontSize, Rectangle pageSize){
        ItextPdfHeaderFooter headerFooter = new ItextPdfHeaderFooter(bf,presentFontSize,pageSize);
        writer.setPageEvent(headerFooter);
    }

    /**
     * @param srcPdf    pdf源文件
     * @param distPdf   最终输出路径
     * @param layerPathArr  图层列表
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    public static String markLocalImage42Dist(String srcPdf, String distPdf, List<String> layerPathArr)
            throws IOException, DocumentException {
        File srcPdfFile = new File(srcPdf);
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
            Image img = Image.getInstance(layerPathArr.get(0));
            Image img1 = Image.getInstance(layerPathArr.get(0));
            Image img2 = Image.getInstance(layerPathArr.get(0));
            Image img3 = Image.getInstance(layerPathArr.get(0));
            Image img4 = Image.getInstance(layerPathArr.get(0));
            Image img5 = Image.getInstance(layerPathArr.get(0));
            Image img6 = Image.getInstance(layerPathArr.get(0));
            Image img7 = Image.getInstance(layerPathArr.get(0));
            Image img8 = Image.getInstance(layerPathArr.get(0));
            Image img9 = Image.getInstance(layerPathArr.get(0));
            Image img10 = Image.getInstance(layerPathArr.get(0));
            Image img11 = Image.getInstance(layerPathArr.get(0));
            Image img12 = Image.getInstance(layerPathArr.get(0));
            Image img13 = Image.getInstance(layerPathArr.get(0));
            Image img14 = Image.getInstance(layerPathArr.get(0));
            Image img15 = Image.getInstance(layerPathArr.get(0));
            Image img16 = Image.getInstance(layerPathArr.get(0));
            Image img17 = Image.getInstance(layerPathArr.get(0));
            img.setRotation((float) (Math.PI / 6));
            img1.setRotation((float) (Math.PI / 6));
            img2.setRotation((float) (Math.PI / 6));
            img3.setRotation((float) (Math.PI / 6));
            img4.setRotation((float) (Math.PI / 6));
            img5.setRotation((float) (Math.PI / 6));
            img6.setRotation((float) (Math.PI / 6));
            img7.setRotation((float) (Math.PI / 6));
            img8.setRotation((float) (Math.PI / 6));
            img9.setRotation((float) (Math.PI / 6));
            img10.setRotation((float) (Math.PI / 6));
            img11.setRotation((float) (Math.PI / 6));
            img12.setRotation((float) (Math.PI / 6));
            img13.setRotation((float) (Math.PI / 6));
            img14.setRotation((float) (Math.PI / 6));
            img15.setRotation((float) (Math.PI / 6));
            img16.setRotation((float) (Math.PI / 6));
            img17.setRotation((float) (Math.PI / 6));
            img.setAbsolutePosition(0, 0);
            img1.setAbsolutePosition(0, 150);
            img2.setAbsolutePosition(0, 300);
            img3.setAbsolutePosition(0, 450);
            img4.setAbsolutePosition(0, 600);
            img5.setAbsolutePosition(0, 750);
            img6.setAbsolutePosition(200, 0);
            img7.setAbsolutePosition(200, 150);
            img8.setAbsolutePosition(200, 300);
            img9.setAbsolutePosition(200, 450);
            img10.setAbsolutePosition(200, 600);
            img11.setAbsolutePosition(200, 750);
            img12.setAbsolutePosition(400, 0);
            img13.setAbsolutePosition(400, 150);
            img14.setAbsolutePosition(400, 300);
            img15.setAbsolutePosition(400, 450);
            img16.setAbsolutePosition(400, 600);
            img17.setAbsolutePosition(400, 750);

            //给每一页PDF都 打上水印
            for (int i=1;i<=n;i++){
                over = stamp.getOverContent(i);
                PdfGState gState = new PdfGState();
                gState.setFillOpacity(0.5f);
                over.setGState(gState);
                over.addImage(img);
                over.addImage(img1);
                over.addImage(img2);
                over.addImage(img3);
                over.addImage(img4);
                over.addImage(img5);
                over.addImage(img6);
                over.addImage(img7);
                over.addImage(img8);
                over.addImage(img9);
                over.addImage(img10);
                over.addImage(img11);
                over.addImage(img12);
                over.addImage(img13);
                over.addImage(img14);
                over.addImage(img15);
                over.addImage(img16);
                over.addImage(img17);
            }
        }
        stamp.close();
        reader.close();
        return distPdf;
    }
}
