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
        Document document = new Document(PageSize.A4,0,0,10,10);

        int i = (int) (Math.random()*100);
        String originalFile = "D:\\pdf\\test"+i+".pdf";
        String tempFile = "D:\\pdf\\temp\\test"+i+".pdf";
        String imgPath = "E:\\workspace\\itextDemo\\src\\main\\resources\\1.gif";
        //String imgPath2 = "E:\\workspace\\itextDemo\\src\\main\\resources\\waterMark2.png";
        Image image7 = Image.getInstance("E:\\workspace\\itextDemo\\src\\main\\resources\\7.png");
        Image image8 = Image.getInstance("E:\\workspace\\itextDemo\\src\\main\\resources\\f.png");
        List<String> list1 = new ArrayList<String>();

        list1.add(imgPath);
        //设置字体
        BaseFont baseFont = BaseFont.createFont("E:\\workspace\\itextDemo\\src\\main\\resources\\typeface\\simsun.ttf",BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

        Font fontTitle = new Font(baseFont,16,Font.BOLD);
        Font font12 = new Font(baseFont,12);
        Font font10 = new Font(baseFont,10);
        Font font10_b = new Font(baseFont,10,Font.BOLD);
        Font font10_gray = new Font(baseFont,10,Font.NORMAL,new BaseColor(100,100,100));
        Font font8 = new Font(baseFont,8);
        Font font8_b = new Font(baseFont,8,Font.BOLD);
        Font font8_gray = new Font(baseFont,8,Font.NORMAL,new BaseColor(100,100,100));
        Font font6 = new Font(baseFont,6);
        Font font6_gray = new Font(baseFont,6,Font.NORMAL,new BaseColor(90,90,90));


        //设置图片透明度
        //transparentImage(imgPath,imgPath2,3,"png");
        try {
            //将 文件写入到地址
            PdfWriter.getInstance(document, new FileOutputStream("D:\\pdf\\test" + i + ".pdf"));
            //打开文本
            document.open();

            //设置页码
            //setFooter(pdfWriter,baseFont,10,PageSize.A4);

            PdfPTable table = new PdfPTable(3);
            table.setTotalWidth(100);
            table.setWidths(new int[]{30,40,30});

            //第一列   标题
            PdfPCell cell = new PdfPCell();
            Paragraph paragraph = new Paragraph();
            paragraph.setFont(fontTitle);
            Phrase phrase = new Phrase("员工行程导出");
            paragraph.add(phrase);
            cell.addElement(paragraph);
            cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            cell.disableBorderSide(13);
            cell.setFixedHeight(30);
            table.addCell(cell);

            //第二列   所属公司
            PdfPCell cell2 = new PdfPCell();
            Paragraph paragraph2 = new Paragraph();
            paragraph2.setAlignment(Element.ALIGN_LEFT);
            paragraph2.setFont(font12);
            Phrase phrase2 = new Phrase(orgName);
            paragraph2.add(phrase2);
            cell2.addElement(paragraph2);
            cell2.setFixedHeight(30);
            cell2.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            cell2.disableBorderSide(13);
            table.addCell(cell2);


            //第三列   导出时间
            PdfPCell cell3 = new PdfPCell();
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Paragraph paragraph3 = new Paragraph("导出时间：" + simpleDateFormat.format(date));
            paragraph3.setFont(font8);
            paragraph3.setAlignment(Element.ALIGN_RIGHT);
            cell3.addElement(paragraph3);
            cell3.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
            cell3.setFixedHeight(30);
            cell3.setPaddingBottom(8);
            cell3.disableBorderSide(13);
            table.addCell(cell3);






            PdfPTable table1 = new PdfPTable(2);
            table1.setTotalWidth(100);
            table1.setWidths(new int[]{10,90});

            //第一列   名称
            PdfPCell cell4 = new PdfPCell();
            Paragraph paragraph4 = new Paragraph();
            paragraph4.setFont(font10_b);
            Phrase phrase4 = new Phrase(userName);
            paragraph4.add(phrase4);
            cell4.disableBorderSide(15);
            cell4.addElement(paragraph4);

            table1.addCell(cell4);

            //第二列   部门
            PdfPCell cell5 = new PdfPCell();
            Paragraph paragraph5 = new Paragraph();
            Font font5 = new Font(baseFont,10);
            paragraph5.setFont(font10_gray);
            Phrase phrase5 = new Phrase(orgName + "部门");
            paragraph5.add(phrase5);
            cell5.disableBorderSide(15);
            cell5.addElement(paragraph5);

            table1.addCell(cell5);


            //第三 部分     查询区间
            PdfPTable table2 = new PdfPTable(1);
            table2.setTotalWidth(100);
            PdfPCell cell6 = new PdfPCell();
            Paragraph paragraph1 = new Paragraph();
            Date date1 = new Date();
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy.mm.dd");
            Phrase phrase1 = new Phrase("行程时间：" + simpleDateFormat1.format(date1) + " - " + simpleDateFormat1.format(date));
            paragraph1.setFont(font10);
            paragraph1.add(phrase1);
            cell6.addElement(paragraph1);
            cell6.disableBorderSide(15);
            cell6.setFixedHeight(50);
            table2.addCell(cell6);

            document.add(table);
            document.add(table1);
            document.add(table2);


            //变量部分
            for (int k=0;k<commons.size();k++){
                //正文部分
                PdfPTable table5 = new PdfPTable(6);

                table5.setTotalWidth(100);
                table5.setWidths(new int[]{15,5,7,8,41,24});

                //第一列
                PdfPCell cell10 = new PdfPCell();
                cell10.setFixedHeight(25);
                Paragraph paragraph10 = new Paragraph();
                paragraph10.setFont(font8_gray);
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy年MM月dd日");
                Phrase phrase10 = new Phrase(simpleDateFormat2.format(commons.get(k).getTravelDate()));
                SimpleDateFormat simpleDateFormat3 =new SimpleDateFormat("hh:mm");
                paragraph10.add(phrase10);
                paragraph10.setAlignment(Element.ALIGN_RIGHT);
                Paragraph paragraph6 = new Paragraph(simpleDateFormat3.format(commons.get(k).getTravelDate()));
                paragraph6.setAlignment(Element.ALIGN_RIGHT);
                paragraph6.setFont(font6_gray);
                cell10.disableBorderSide(15);
                cell10.setUseAscender(true);
                cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell10.addElement(paragraph10);
                cell10.addElement(paragraph6);

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


                //机票， 酒店， 火车
                PdfPCell cell13 = new PdfPCell();
                cell13.setFixedHeight(25);
                Paragraph paragraph13 = new Paragraph();
                paragraph13.setFont(font8_gray);
                Phrase phrase13_1 = new Phrase(temp + "  ");


                Chunk chunk13_2 = null;
                if (commons.get(k).getOrderType().equals("HOTEL")){
                    chunk13_2 = new Chunk(commons.get(k).getToCity() + "  ");
                }else{
                    chunk13_2 = new Chunk(commons.get(k).getFromCity() + "-" + commons.get(k).getToCity() + "  ");
                }

                String code = "";
                if (commons.get(k).getOrderType().equals("TRAIN")){
                    code = commons.get(k).getTrainCode();
                }else if (commons.get(k).getOrderType().equals("HOTEL")){
                    code = commons.get(k).getHotelName();
                }else if (commons.get(k).getOrderType().equals("AIRCRAFT")){
                    code = commons.get(k).getFlightNo();
                }

                paragraph13.add(phrase13_1);

                cell13.addElement(paragraph13);
                cell13.setBackgroundColor(new BaseColor(215, 215, 215));
                cell13.disableBorderSide(15);
                cell13.setUseAscender(true);
                cell13.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
                cell13.setVerticalAlignment(Element.ALIGN_MIDDLE);

                table5.addCell(cell13);


                //出发地 and 目的地
                PdfPCell cellCity = new PdfPCell();
                cellCity.setFixedHeight(25);
                cellCity.disableBorderSide(15);
                Paragraph paragraphCity = new Paragraph();
                Phrase phraseCity = new Phrase(temp);
                chunk13_2.setFont(font10_b);
                paragraphCity.add(chunk13_2);
                Chunk chunk13_3 = new Chunk(code);
                chunk13_3.setFont(font8_gray);
                paragraphCity.add(chunk13_3);

                cellCity.addElement(paragraphCity);
                cellCity.setBackgroundColor(new BaseColor(215, 215, 215));
                cell13.disableBorderSide(15);
                cellCity.setUseAscender(true);
                cellCity.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
                cellCity.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table5.addCell(cellCity);



               // 5
                PdfPCell cell15 = new PdfPCell();
                cell15.setFixedHeight(25);
                Paragraph paragraph15 = new Paragraph();
                paragraph15.setFont(font8_b);
                paragraph15.setAlignment(Element.ALIGN_RIGHT);
                paragraph15.add(new Phrase("订单号：" + commons.get(k).getOrderId()));
                cell15.addElement(paragraph15);
                cell15.setBackgroundColor(new BaseColor(215, 215, 215));
                cell15.disableBorderSide(15);
                cell15.setUseAscender(true);
                cell15.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
                cell15.setVerticalAlignment(Element.ALIGN_MIDDLE);

                table5.addCell(cell15);

                document.add(table5);



                //下半部分内容
                PdfPTable table10 = new PdfPTable(4);
                table10.setWidths(new int[]{15,5,60,20});
                PdfPCell cell15_1 = new PdfPCell();
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
                if (k<commons.size()-1){
                    if (commons.get(k).getOrderId().equals(commons.get(k+1).getOrderId())){
                        image8.scaleAbsolute(10,10);
                        image8.setAbsolutePosition(10,10);
                        cell16_1.addElement(image8);
                    }else{
                        image7.scaleAbsolute(10,10);
                        image7.setAbsolutePosition(10,10);
                        cell16_1.addElement(image7);
                    }
                }
                cell16_1.setUseAscender(true);
                cell16_1.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
                cell16_1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell16_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell16_1.disableBorderSide(15);
                table10.addCell(cell16_1);


                //第三列 ， 差旅类型
                PdfPCell cell17_1 = new PdfPCell();
                Paragraph paragraph17_1 = null;
                cell17_1.disableBorderSide(15);
                if (commons.get(k).getTravelPlanNo()!=null && !commons.get(k).getTravelPlanNo().equals("")){
                    paragraph17_1 = new Paragraph("差旅类型：" +"【"+ commons.get(k).getTravelType() + "】" + "  " + commons.get(k).getTravelReason());
                }else{
                    paragraph17_1 = new Paragraph("无差旅计划");
                }
                paragraph17_1.setFont(font8);
                cell17_1.addElement(paragraph17_1);
                table10.addCell(cell17_1);

                //第四列， 费用归属
                PdfPCell cell17_2 = new PdfPCell();
                Paragraph paragraph17_2 = new Paragraph();
                paragraph17_2.setAlignment(Element.ALIGN_RIGHT);
                cell17_2.disableBorderSide(15);
                Chunk chunk2_4 = new Chunk("费用归属：" + commons.get(k).getCostCenterName());
                paragraph17_2.setFont(font8);
                paragraph17_2.add(chunk2_4);
                cell17_2.addElement(paragraph17_2);
                table10.addCell(cell17_2);

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

    public static void main(String[] args) {

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm");
        System.out.println(simpleDateFormat.format(date));
        String format = simpleDateFormat.format(date);
        String date1 = format.substring(format.indexOf(" "));
        System.out.println(date1);

    }

}
