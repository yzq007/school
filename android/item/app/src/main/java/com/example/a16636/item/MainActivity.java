package com.example.a16636.item;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     EditText ename;
    EditText epassword;
    Button button;
    String name;
    CheckBox remember;
    CheckBox zidong;
    SharedPreferences sp;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ename= (EditText) findViewById(R.id.ename);
        epassword= (EditText) findViewById(R.id.epassword);
        button= (Button) findViewById(R.id.button);
        remember= (CheckBox) findViewById(R.id.remember);
        zidong= (CheckBox) findViewById(R.id.zidong);
        name = ename.getText().toString();
        password = epassword.getText().toString();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=ename.getText().toString();
                password=epassword.getText().toString();
                if (name.equals("abc")){
                    if (password.equals("123456")){
                        Intent intent=new Intent(MainActivity.this,main.class);
                        startActivity(intent);
                        finish();
                    }else {
                        AlertDialog.Builder builder1=new AlertDialog.Builder(MainActivity.this);
                        builder1.setTitle("提示");
                        builder1.setIcon(android.R.drawable.ic_dialog_info);
                        builder1.setMessage("请输入正确的密码");
                        builder1.setPositiveButton("确定", null);
                        builder1.setNegativeButton("取消", null);
                        builder1.show();
                    }
                }else{
                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("提示");
                    builder.setIcon(android.R.drawable.ic_dialog_info);
                    builder.setMessage("请输入正确的用户名");
                    builder.setPositiveButton("确定", null);
                    builder.setNegativeButton("取消", null);
                    builder.show();
                }
            }
        });

    }
    private void init() {


        MyCheckedChangeListener lis=new MyCheckedChangeListener();
        remember.setOnCheckedChangeListener(lis);
        zidong.setOnCheckedChangeListener(lis);

        sp = getSharedPreferences("userInfo", MODE_PRIVATE);
        boolean chooseRemember =sp.getBoolean("remember", false);
        boolean chooseAutoLogin =sp.getBoolean("zidong", false);
        //      Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

        //如果上次选了记住密码，那进入登录页面也自动勾选记住密码，并填上用户名和密码
        if(chooseRemember){
            remember.setChecked(true);
            ename.setText(sp.getString("USER_NAME", ""));
            epassword.setText(sp.getString("PASSWORD", ""));
        }
        //如果上次登录选了自动登录，那进入登录页面也自动勾选自动登录,填上用户名和密码并
        if(chooseAutoLogin){
            zidong.setChecked(true);
            name=sp.getString("USER_NAME","");
            password=sp.getString("PASSWORD","");
//            usernameTxt.setText(userName);
//            passwordTxt.setText(password);
            if (name.equals("abc")
                    && password.equals("123456")) {
                Intent intent = new Intent(MainActivity.this, main.class);
                startActivity(intent);
            }
        }

    }
    public void checkLogin(View v){
        name = ename.getText().toString();
        password = epassword.getText().toString();
        SharedPreferences.Editor editor =sp.edit();

        if (name.equals("abc")
                && password.equals("123456")) {
            //保存用户名和密码
            editor.putString("USER_NAME", name);
            editor.putString("PASSWORD", password);

            //是否自动登录
            if(zidong.isChecked()){
                editor.putBoolean("remember", true);
                editor.putBoolean("zidong", true);
            }
            else if(remember.isChecked()){
                editor.putBoolean("remember", true);
                editor.putBoolean("zidong", false);
            }
            else {
                editor.putBoolean("remember", false);
                editor.putBoolean("zidong", false);
            }

            editor.commit();

            //跳转
            Intent intent =new Intent(MainActivity.this,main.class);
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "用户名或密码错误，请重新登录!",
                    Toast.LENGTH_SHORT).show();
        }
    }

    class MyCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.zidong:
                    if (isChecked)
                        remember.setChecked(true);
                    break;
                case R.id.remember:
                    if (!isChecked)
                        zidong.setChecked(false);
                    break;
                default:
                    break;
            }
        }
    }
}
