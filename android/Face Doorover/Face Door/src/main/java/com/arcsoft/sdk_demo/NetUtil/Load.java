package com.arcsoft.sdk_demo.NetUtil;

import android.util.Log;
import android.widget.EditText;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.io.File;

import okhttp3.Call;
import okhttp3.Response;

public class Load {
    public String status=null;
    //MainActivity mainActivity=new MainActivity();
    EditText et_id;
    public Load(){

    }
    public void upload(String path,String name){

        Log.d("tag", "upload: ");
        File file = new File(path,name); //trace.txt 换成手机根目录下的文件
        //文件上传

        OkHttpUtils.post()
                .addFile("file",name , file)  //增加addFile可以多文件上传

                .url("http://106.15.227.196:8080/FileUploadDemo/servlet/formservlet") //换成自己的ip地址
                .build()//
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {
                        status="上传成功";

                        // Log.d("tag", "parseNetworkResponse: ");
                        Log.d("tag", status+"");
                        return null;
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        status="上传失败,请检查网络是否已连接";
                        Log.d("tag", "onError: ");
                        Log.d("tag", "message:" + e.getMessage());
                       // Log.d("tag", mainActivity.isSuccess+"");
                    }
                    @Override
                    public void onResponse(Object response, int id) {
                        status="上传成功";

//                        Toast.makeText(mainActivity, status, Toast.LENGTH_SHORT).show();
                        // Toast.makeText(MainActivity.class, status, Toast.LENGTH_SHORT).show();
                        Log.d("tag", status+"");
                        Log.d("tag", "onResponse: ");
                    }
                });
    }
}
