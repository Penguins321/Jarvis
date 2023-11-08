package com.study.prictice.demos.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.StringWriter;
import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 * @Author ouyang    @Date 2023/5/4
 * @Description
 * @menu
 */
@Slf4j
public class XmlAppend {

    private static String getXmlByPurchaseInVO() {
        return "(SELECT MAX(lastModifyDate)\n" +
                "   FROM( VALUES\n" +
                "         (ISNULL(dnmaketime, '1900-1-1')),\n" +
                "         (ISNULL(dnmodifytime, '1900-1-1')),\n" +
                "         (ISNULL(dnverifytime, '1900-1-1'))\n" +
                ") AS #temp (lastModifyDate)) ";
    }

    @Test
    public void test(){

        LocalDate date1 = LocalDate.now(Clock.system(ZoneId.of("Asia/Shanghai")));
        String startDate = date1.toString().concat(" 00:00:00");
        String endDate = date1.toString().concat(" 23:59:59");

        StringWriter writer = new StringWriter();
        String start = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "<ufinterface sender=\"" + "0012021" + "\" receiver=\"u8\" display=\"材料出库单\"  roottag=\"Deliveryorder\" proc=\"query\" " +
                "codeexchanged=\"N\" exportneedexch=\"N\" paginate=\"0\" RemoveEmpty=\"0\"><Finishedgoods>";
        String end = "</Finishedgoods></ufinterface>";
        writer.append(start);

        writer.append("<field display=\"最后更新时间\" name=\"");
        writer.append(getXmlByPurchaseInVO());
        writer.append("\" operation=\"&gt;=\" value=\"");
        writer.append(startDate);
        writer.append("\" logic=\"and\"/>");
        writer.append("<field display=\"最后更新时间\" name=\"");
        writer.append(getXmlByPurchaseInVO());
        writer.append("\" operation=\"&lt;=\" value=\"");
        writer.append(endDate);
        writer.append("\" logic=\"or\"/>");


        writer.append("<field display=\"审核人\" name=\"isnull(cHandler,'')\" operation=\"=\" value=\"\" logic=\"\" />");
        writer.append(end);

        System.out.println(writer);



    }



}
