package com.study.prictice.demos.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Practice {

    @Autowired
    private static RedisTemplate redisTemplate;


    public static void main(String[] args) {


        HashMap<Object, Object> map = new HashMap<>();

        map.put("",1);
        map.put(null,2);
        map.put(null,3);

        System.out.println(map.get(null));

        Practice practice = new Practice();
        int[] sort = practice.sort();
        for(int i : sort){
            System.out.print(i);
        }
    }



    public int[] sort(){
        int[] arr = new int[] {1, 8, 5,2,4,9,7};

        for (int i = arr.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[(j+1)];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    @Test
   public void test(){
       String str = "2023-03-19T03:38:43.012";
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       System.out.println(format.format(str));
   }

   @Test
   public void tset(){
        String dcreatesystime ="2023-03-15 16:00:00";
       String sender = "0092021";
       String startDate = "2023-02-22 16:00:00";
       String endDate = "2023-02-22 17:00:00";
       StringWriter xml = new StringWriter();
       xml.append("<?xml version=\"1.0\" encoding=\"utf-8\"?><ufinterface sender=\"" + sender + "\" receiver=\"u8\" roottag=\"Vouch\" proc=\"query\" codeexchanged=\"N\" exportneedexch=\"N\" paginate=\"0\" RemoveEmpty=\"0\"><SaleRecord>");
       if (dcreatesystime != null) {
           xml.append("<field display=\"应收单\" name=\"cVouchType\" operation=\"=\" value=\"48\" logic=\"and\" />");
           xml.append("<field display=\"应收单\" name=\"");
           xml.append(getXmlByVoucherVO());
           xml.append("\" operation=\"&gt;=\" value=\"");
           xml.append(dcreatesystime);
           xml.append("\" logic=\"or\" />");
           xml.append("<field display =\"审核人\" name = \"ISNULL(cCheckMan,'')");
           xml.append("\" operation=\"=\" value=\"");
           xml.append("\" logic=\"\" />");

       } else {
           xml.append("<field display=\"应收单\" name=\"cVouchType\" operation=\"=\" value=\"R0\" logic=\"and\" />");
           xml.append("<field display=\"应收单\" name=\"");
           xml.append(getXmlByVoucherVO());
           xml.append("\" operation=\"&gt;=\" value=\"");
           xml.append(startDate);
           xml.append("\" logic=\"and\" />");
           xml.append("<field display=\"应收单\" name=\"");
           xml.append(getXmlByVoucherVO());
           xml.append("\" operation=\"&lt;=\" value=\"");
           xml.append(endDate);
           xml.append("\" logic=\"or\" />");
           xml.append("<field display =\"审核人\" name = \"ISNULL(cCheckMan,'')");
           xml.append("\" operation=\"=\" value=\"");
           xml.append("\" logic=\"\" />");
       }
       xml.append("<pageinfo pagesize=\"" + 5 + "\" page=\"" + 1 + "\" />\n");
       xml.append("</SaleRecord></ufinterface>");
       System.out.println(xml.toString());
   }


    // 收款单查询条件
    private static String getXmlByVoucherVO() {
        return "(SELECT MAX(lastModifyDate)\n" +
                "   FROM( VALUES\n" +
                "         (ISNULL(dcreatesystime, '1900-1-1')),\n" +
                "         (ISNULL(dmodifysystime, '1900-1-1')),\n" +
                "         (ISNULL(dverifysystime, '1900-1-1'))\n" +
                ") AS #temp (lastModifyDate)) ";
    }


    @Test
    public void tset2() throws ParseException {
        String startDate="2020/11/13";
        String endDate= "2020/11/14";
        String startDate2="2020/11/13 00:00:00";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try{

            startDate = startDate.concat(" 00:00:00");
            System.out.println(startDate);
            Date parse = simpleDateFormat.parse(startDate);
            System.out.println(simpleDateFormat.format(parse));

        }catch (Exception e){
        }


    }

    public static Date getMaxDate(Date date1,Date date2,Date date3){
        Date temp = null;
        if(date1.before(date2)){
            if(date2.before(date3)){
                temp = date3;
            }else {
                temp = date2;
            }
        }else {
            temp = date1;
            if(date1.before(date3)){
                temp = date3;
            }else {
                temp = date1;
            }
        }
        return temp;
    }

    @Test
    public void test3(){
        String startDate="2020/11/13 00:00:00";
        String endDate= "2020/11/14 23:59:59";
        String ssDate = null;

        // System.out.println(startDate.compareTo(endDate));
        // System.out.println(startDate.compareTo(ssDate));
        // System.out.println(startDate > ssDate);
        String s = startDate.replaceAll("/", "-");
        System.out.println(s);

    }

    @Test
    public void test4(){
        List<String> list = new ArrayList<>();

        list.add("2020-11-13 00:00:00");
        list.add("2020-11-14 00:00:30");
        list.add("2020-11-15 00:00:00");
        System.out.println(        Collections.max(list)
);

    }
}
