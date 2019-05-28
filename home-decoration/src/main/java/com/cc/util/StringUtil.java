package com.cc.util;

import com.cc.model.GalleryDesign;
import net.sf.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class StringUtil {
    final static private String tag = "com.cc.util.StringUtil";
    final static private int MAX_NUM = 9999;

    public static Map<String, Object> filteChoiceByJSONObject(JSONObject jsonObject) {
        Map<String, Object> map = new HashMap<String, Object>();
        String houseType = jsonObject.get("houseType").toString();
        String cost = jsonObject.get("cost").toString();
        String area = jsonObject.get("area").toString();
        String style = jsonObject.get("style").toString();
        System.out.println(tag + ":  filteChoiceByJSONObject:  houseType: " + houseType
                + "  cost: " + cost
                + "  area: " + area
                + "  style: " + style);
        ;
        String[] costArr = cost.split("~");
        String[] areaArr = area.split("~");
        int[] intCostArr = new int[2];
        int[] intAreaArr = new int[2];

        convertStringArrToIntArr(costArr, intCostArr);
        convertStringArrToIntArr(areaArr, intAreaArr);

        map.put("houseType", houseType);
        map.put("style", style);
        map.put("cost", intCostArr);
        map.put("area", intAreaArr);
        return map;

    }

    public static void convertStringArrToIntArr(String[] arr, int[] intArr) {
        System.out.println(tag + ":  convertStringArrToIntArr:  arr: " + Arrays.toString(arr));
        if (isEmpty(arr[0])) {
            intArr[0] = -1;
            return;
        }
        if (arr[0].contains("以下") || arr[0].contains("以上")) {
            String num;
            if (arr[0].contains("以下")) {
                intArr[0] = 0;
                //提取cost中数字
                num = arr[0].replaceAll("[^0-9]+", "");
                intArr[1] = Integer.parseInt(num);
            } else if (arr[0].contains("以上")) {
                //提取cost中数字
                num = arr[0].replaceAll("[^0-9]+", "");
                intArr[0] = Integer.parseInt(num);
                //上限默认为MAX_NUM
                intArr[1] = MAX_NUM;

            }

        } else {
            intArr[0] = Integer.parseInt(arr[0].replaceAll("[^0-9]+",""));
            intArr[1] = Integer.parseInt(arr[1].replaceAll("[^0-9]+",""));
        }
    }

    public static boolean isEmpty(String string) {
        if (string == null) {
            return true;
        }
        if ("".equals(string.trim())) {
            return true;
        }
        return false;
    }


    public static Date StringToSQLDate(String string) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
//            date = (Date)sdf.parse(string);
            date = new Date(sdf.parse(string).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("日期格式不对");
        }
        return date;
    }

    public static String getCurrentUtilDate() {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }


    public static void main(String[] args) {
//        String string = "2018-12-20";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date date = new Date(sdf.parse(string).getTime());
//            System.out.println("date: " + date.toString());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        String str2 = "{\"houseType\":\"\",\"area\":\"60~80\",\"cost\":\"6~8\",\"style\":\"田园\"}";
        JSONObject jsonObject = JSONObject.fromObject(JSONObject.fromObject(str2));
        filteChoiceByJSONObject(jsonObject);

        String str1 = "30以下";
        String s1 = str1.replaceAll("[^0-9]+", "");
        System.out.println(s1);

        String str3 = "";
        String[] split = str3.split("~");
        int arr[] = new int[2];
        convertStringArrToIntArr(split, arr);
        System.out.println(arr[0] + " >>>" + arr[1]);

        Object object = "string tr";
        System.out.println(object.toString());
    }
}
