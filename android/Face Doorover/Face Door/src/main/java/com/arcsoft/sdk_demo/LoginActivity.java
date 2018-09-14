package com.arcsoft.sdk_demo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arcsoft.sdk_demo.Fragment.HomeActivity;
import com.arcsoft.sdk_demo.webdb.TransObjectToWeb;
import com.arcsoft.sdk_demo.webdb.User;

public class LoginActivity extends Activity {
    Button sign;
    EditText ename;
    EditText epassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sign=(Button) findViewById(R.id.sign);
        ename=findViewById(R.id.ename);
        epassword=findViewById(R.id.epassword);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=ename.getText().toString();
                String password= String.valueOf(epassword.getText().toString());
                if (name.equals("door")){
                    if (password.equals("330324")){
                        Intent signintent=new Intent(LoginActivity.this,WelcomeActivity.class);
                        startActivity(signintent);
                        finish();
                    }
                    else{
                        AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this);
                        builder.setTitle("提示");
                        builder.setIcon(android.R.drawable.ic_dialog_info);
                        builder.setMessage("请输入正确的密码");
                        builder.setPositiveButton("确定",null);
                        builder.setNegativeButton("取消",null);
                        builder.show();
                    }
                }  else{
                    AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this);
                    builder.setTitle("提示");
                    builder.setIcon(android.R.drawable.ic_dialog_info);
                    builder.setMessage("请核对您的身份");
                    builder.setPositiveButton("确定", null);
                    builder.setNegativeButton("取消", null);
                    builder.show();
                }
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//
//
//                        User user = new User("张小凡","男",19);  //实例化用于测试的传输对象
//                        TransObjectToWeb toWeb = new TransObjectToWeb();//实例化该类对象，调用其传输对象方法
//                        boolean flag = toWeb.sendToWeb(user);
//                        Log.d("TAG", "run: ");
//                        if (flag) {
//                            Looper.prepare();
//                            Toast.makeText(LoginActivity.this, "对象传输成功！", Toast.LENGTH_SHORT).show();
//                            Looper.loop();
//                        } else {
//                            Looper.prepare();
//                            Toast.makeText(LoginActivity.this, "网络繁忙！", Toast.LENGTH_SHORT).show();
//                            Looper.loop();
//                        }
//                    }
//                }).start();
            }

        });
    }
}

