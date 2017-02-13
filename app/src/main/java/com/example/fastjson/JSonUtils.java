package com.example.fastjson;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JSonUtils {
    private static String TAG=MainActivity.class.getSimpleName();

    //字符串内容 [{"age":42,"id":1,"male":true,"name":"Sherlock Holmes","schoolId":1},{"age":42,"id":2,"male":false,"name":"John Watson","schoolId":1}]
    public static final String JSON_ARRAY = "[{\"age\":42,\"id\":1,\"male\":true,\"name\":\"Sherlock Holmes\",\"schoolId\":1}," +
            "{\"age\":42,\"id\":2,\"male\":false,\"name\":\"John Watson\",\"schoolId\":1}]";

    //该字符串是 {"age":42,"id":1,"male":true,"name":"Sherlock Holmes","schoolId":1} 注意将 " 转为 \"
    public static final String JSON_STUDENT =  "{\"age\":42,\"id\":1,\"male\":true,\"name\":\"Sherlock Holmes\",\"schoolId\":1}";


    /**
     * JSONArray
     */
    public static void JSONArrayMethod() {
        // 创建一个 StudentBean 对象
        StudentBean student_Bean_s = new StudentBean(1, "Sherlock Holmes", 42, true, 1);
        // 再创建一个 StudentBean 对象
        StudentBean student_Bean_j = new StudentBean(2, "John Watson", 42, false, 1);
        // 将两个 StudentBean 对象放到 List 集合中
        List<StudentBean> studentBeans = new ArrayList<StudentBean>();
        studentBeans.add(student_Bean_s);
        studentBeans.add(student_Bean_j);

        // 将 List 集合对象转为 JSONArray 对象
        JSONArray jsonArray = (JSONArray) JSON.toJSON(studentBeans);
        Log.i(TAG, "List -> JSONArray : " + jsonArray);

        //将 List 集合 转化成 json 字符串
        String json_str = JSON.toJSONString(studentBeans, true);
        Log.i(TAG, "List -> json Str" + json_str);

        //json 字符串转为 List 集合
        List<StudentBean> students1 = JSON.parseArray(json_str, StudentBean.class);
        Log.i(TAG, "json Str -> List : " + students1);

        //json 字符串转 JSONArray
        JSONArray array1 = JSON.parseArray(json_str);
        Log.i(TAG, "json Str -> JSONArray : " + array1);
    }



    /**
     * JSONObject
     */
    public static void JSONObjectMethod() {
        //创建 一个 StudentBean 对象
        StudentBean studentBean = new StudentBean(1, "Sherlock Holmes", 42, true, 1);

        //将 Java Bean 对象转为 JSONObject 对象
        JSONObject object = (JSONObject) JSON.toJSON(studentBean);
        //打印 JSONObject 对象
        Log.i(TAG,object.toString());

        //获取 JSONObject 对象的 age 和 male 值
        String age = object.getString("age");
        boolean isMale = object.getBoolean("male");
        Log.i(TAG, "age : " + age + " , male : " + isMale);

        //向 JSONObject 对象中添加单个属性
        object.put("action", "fuck");
        Log.i(TAG, object.toString());

        //向 JSONObject 对象中添加多个属性
        Map<String, String> map = new HashMap<String, String>();
        map.put("home", "American");
        map.put("school", "harvard");
        object.putAll(map);
        Log.i(TAG, object.toJSONString());

        //移除 JSONObject 对象中的单个属性
        object.remove("action");
        Log.i(TAG, object + "");

        //获取 JSONObject 中的属性个数
        Log.i(TAG, object.size()+"");
    }



    /**
     * JSON.parse()
     */
    public static void parseMethod() {
        //将 json 字符串转为 JSONObect 对象
        JSONObject object = (JSONObject) JSON.parse(JSON_STUDENT);
        //打印 JSONObject 对象
        Log.i(TAG,object+"");

        //将 json 字符串 转为 JSONArray 对象
        JSONArray array = (JSONArray) JSON.parse(JSON_ARRAY);
        //打印 JSONArray 对象
        Log.i(TAG,array+"");
    }



    /**
     * JSON.parseObject()
     */
    public static void parseObjectMethod() {
        //将 json 字符串转为 JSONObject 对象
        JSONObject object = JSON.parseObject(JSON_STUDENT);
        //打印 JSONObject 对象
        Log.i(TAG,object+"");

        //将 json 字符串转为 StudentBean 对象  JSON.parseObject(String text, Class<StudentBean> clazz)
        StudentBean studentBean = JSON.parseObject(JSON_STUDENT, StudentBean.class);
        //打印 StudentBean 对象
        Log.i(TAG, studentBean.toString());
    }



    /**
     * JSON.parseArray()
     */
    public static void parseArrayMethod() {
        //将 json 字符串转为 JSONArray 对象
        JSONArray array = JSON.parseArray(JSON_ARRAY);
        //打印 JSONArray 对象
        Log.i(TAG,array+"");

        //将 json 字符串转为 List 集合
        List<StudentBean> studentBeans = JSON.parseArray(JSON_ARRAY, StudentBean.class);
        //打印 List 集合大小
        Log.i(TAG,"studentBeans.size() : " + studentBeans.size());

        //遍历 List 集合中的元素
        for(StudentBean studentBean : studentBeans){
            Log.i(TAG, studentBean.toString());
        }

    }



    /**
     * JSON.toJSON()
     */
    public static void toJSONMethod() {
        //创建一个 StudentBean 对象
        StudentBean student_Bean_s = new StudentBean(1, "Sherlock Holmes", 42, true, 1);

        //将 java bean 对象转为 JSONObject 对象
        JSONObject object = (JSONObject) JSON.toJSON(student_Bean_s);

        //JSONObject 直接打印, 打印 toString() 或者 toJSONString() 输出结果是一样的
        Log.i(TAG, object + " -- 打印 JSONOBject 本身");
        Log.i(TAG, object.toString() + " -- 打印 JSONOBject.toString()");
        Log.i(TAG, object.toJSONString() + " -- 打印 JSONOBject.toJSONString()");


        //再创建一个 StudentBean 对象
        StudentBean student_Bean_j = new StudentBean(2, "John Watson", 42, false, 1);

        //将两个 StudentBean 对象放到 List 集合中
        List<StudentBean> studentBeans = new ArrayList<StudentBean>();
        studentBeans.add(student_Bean_s);
        studentBeans.add(student_Bean_j);

        //将 List 集合对象转为 JSONArray 对象
        JSONArray array = (JSONArray) JSON.toJSON(studentBeans);

        String format_json = JSON.toJSONString(studentBeans, true);
        Log.i(TAG, format_json);


        //JSONArray 直接打印, 打印 toString() 或者 toJSONString() 输出结果是一样的
        Log.i(TAG, array + " -- 打印 JSONArray 本身");
        Log.i(TAG, array.toString() + " -- 打印 JSONArray.toString()");
        Log.i(TAG, array.toJSONString() + " -- 打印 JSONArray.toJSONString()");
    }

    /**
     * JSON.toJSONString()
     */
    public static void toJsonStringMethod() {
        //创建一个 StudentBean 对象
        StudentBean studentBean = new StudentBean(1, "Sherlock Holmes", 42, true, 1);

        //将 StudentBean 对象转为 json 字符串
        String json = JSON.toJSONString(studentBean);
        //打印 json 字符串
        Log.i(TAG,json);



        //将 StudentBean 对象转为 json 字符串, 这个字符串是经过格式化的
        String format_json = JSON.toJSONString(studentBean, true);
        //打印格式化的 json
        Log.i(TAG,format_json);
    }

}