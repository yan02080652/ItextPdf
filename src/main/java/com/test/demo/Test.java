package com.test.demo;

import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {


    public static void main(String[] args) throws IOException, DocumentException {

        List<TravelPlanOrderCommon> list = new ArrayList<TravelPlanOrderCommon>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date date = new Date();
        TravelPlanOrderCommon common1 = new TravelPlanOrderCommon("111122220000","TRAIN","上海","北京","","G1",
                "","", date,null,null,date,"3000","111122220000","产品部",
                new Long(23),"10","谈合作2343546");
        TravelPlanOrderCommon common2 = new TravelPlanOrderCommon("111122220000","HOTEL","上海","北京","","G1",
                "","北京升高酒店(草桥店)", date,null,null,date,"3000","111122220000","产品部",
                new Long(23),"10","wan");
        TravelPlanOrderCommon common3 = new TravelPlanOrderCommon("111122220000","TRAIN","上海","北京","","G1",
                "","", date,null,null,date,"3000","111122220000","产品部",
                new Long(23),"10","lioa");
        TravelPlanOrderCommon common4 = new TravelPlanOrderCommon("111122220000","HOTEL","上海","北京","","",
                "","北京香格里拉大酒店（酒仙桥店）", date,null,null,date,"3000","","产品部",
               null,null,null);
        TravelPlanOrderCommon common5 = new TravelPlanOrderCommon("111122220000","HOTEL","上海","北京","","",
                "","北京香格里拉大酒店（酒仙桥店）", date,null,null,date,"3000","","产品部",
               null,null,null);
        TravelPlanOrderCommon common6 = new TravelPlanOrderCommon("111122220000","HOTEL","上海","北京","","",
                "","北京香格里拉大酒店（酒仙桥店）", date,null,null,date,"3000","","产品部",
               null,null,null);
        TravelPlanOrderCommon common7 = new TravelPlanOrderCommon("111122220000","HOTEL","上海","北京","","",
                "","北京香格里拉大酒店（酒仙桥店）", date,null,null,date,"3000","","产品部",
               null,null,null);
        TravelPlanOrderCommon common8 = new TravelPlanOrderCommon("111122220000","HOTEL","上海","北京","","",
                "","北京香格里拉大酒店（酒仙桥店）", date,null,null,date,"3000","","产品部",
               null,null,null);
        TravelPlanOrderCommon common9 = new TravelPlanOrderCommon("111122220000","HOTEL","上海","北京","","",
                "","北京香格里拉大酒店（酒仙桥店）", date,null,null,date,"3000","","产品部",
               null,null,null);
        TravelPlanOrderCommon common10 = new TravelPlanOrderCommon("111122220000","HOTEL","上海","北京","","",
                "","北京香格里拉大酒店（酒仙桥店）", date,null,null,date,"3000","","产品部",
               null,null,null);
        TravelPlanOrderCommon common11 = new TravelPlanOrderCommon("111122220000","HOTEL","上海","北京","","",
                "","北京香格里拉大酒店（酒仙桥店）", date,null,null,date,"3000","","产品部",
               null,null,null);
        TravelPlanOrderCommon common12 = new TravelPlanOrderCommon("111122220000","HOTEL","上海","北京","","",
                "","北京香格里拉大酒店（酒仙桥店）", date,null,null,date,"3000","","产品部",
               null,null,null);
        TravelPlanOrderCommon common13 = new TravelPlanOrderCommon("111122220000","HOTEL","上海","北京","","",
                "","北京香格里拉大酒店（酒仙桥店）", date,null,null,date,"3000","","产品部",
               null,null,null);
        TravelPlanOrderCommon common14 = new TravelPlanOrderCommon("111122220000","HOTEL","上海","北京","","",
                "","北京香格里拉大酒店（酒仙桥店）", date,null,null,date,"3000","","产品部",
               null,null,null);

        list.add(common1);
        list.add(common2);
        list.add(common3);
        list.add(common4);
        list.add(common5);
        list.add(common6);
        list.add(common7);
        list.add(common8);
        list.add(common9);
        list.add(common10);
        list.add(common11);
        list.add(common12);
        list.add(common13);
        list.add(common14);

        MyDemo.export(list,"Tem测试","萧红");


        String game = getRandom(16);
        System.out.println(game);


    }
    public static String getRandom(int length){
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            val += String.valueOf(random.nextInt(10));
        }
        return val;
    }

}
