package com.arcsoft.sdk_demo.webdb;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class TransObjectToWeb {
    /**
     * 创建方法：将对象传输到 web 端
     * @param user
     */
    private Boolean flag = false;
    public boolean sendToWeb(User user){
        Log.d("TAG","创建连76接");
        try {
            // (1)服务器的访问路径
            Log.d("TAG","创建连接");
            URL url = new URL("http://192.168.1.104:8080/WinSockWeb/WinSockForAndroid");
            Log.d("TAG", "sendToWeb:tghgjkjh ");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();  //实例化连接对象
            http.setDoInput(true);  //可读可写
            http.setDoOutput(true);
            http.setUseCaches(false);  //不允许使用缓存
            http.setRequestMethod("POST");  //设置传输方式为 post
//            http.setRequestMethod("GET");
            http.connect();  //创建连接
            Log.i("TAG","创建连接成功");

            // (2)数据写入流发送至服务器
            OutputStream os = http.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            Log.i("TAG","创建json 对象");
            JSONArray jsonArray = new JSONArray();  //创建 json 对象
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("username",user.getUsername());  //写入对象数据
            jsonObject.put("gender",user.getGender());
            jsonObject.put("age",user.getAge());
            jsonArray.put(jsonObject);
            bw.write(jsonArray.toString());
            bw.flush();

            // (3)数据读取流接收数据
            InputStream is = http.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String result = br.readLine();  //获取web 端返回的数据
            if (result.equals("succeed")) {  //如果返回数据为 succeed 处理成功，否则失败
                flag = true;
            }

            // (4)关闭相关流
            if (os != null)  os.close();
            if (osw != null)  osw.close();
            if (is != null)  is.close();
            if (isr != null)  isr.close();
            if (br != null)  br.close();
            if (bw != null)  bw.close();

        } catch (Exception e){e.printStackTrace();}
        return flag;
    }
}
