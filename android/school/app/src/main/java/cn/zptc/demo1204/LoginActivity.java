package cn.zptc.demo1204;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ydkf051 on 2017/12/4.
 */

public class LoginActivity extends Activity{
    private EditText usernameTxt;
    private EditText passwordTxt;
    private CheckBox rememberCkb;
    private CheckBox autologinCkb;
    private SharedPreferences sp;
    private String userName, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        init();
    }

    private void init() {
        usernameTxt = (EditText) findViewById(R.id.username);
        passwordTxt = (EditText) findViewById(R.id.userpassword);
        rememberCkb = (CheckBox) findViewById(R.id.remember);
        autologinCkb = (CheckBox) findViewById(R.id.autologin);

        MyCheckedChangeListener lis=new MyCheckedChangeListener();
        rememberCkb.setOnCheckedChangeListener(lis);
        autologinCkb.setOnCheckedChangeListener(lis);

        sp = getSharedPreferences("userInfo", MODE_PRIVATE);
        boolean chooseRemember =sp.getBoolean("remember", false);
        boolean chooseAutoLogin =sp.getBoolean("autologin", false);
        //      Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

        //如果上次选了记住密码，那进入登录页面也自动勾选记住密码，并填上用户名和密码
        if(chooseRemember){
            rememberCkb.setChecked(true);
            usernameTxt.setText(sp.getString("USER_NAME", ""));
            passwordTxt.setText(sp.getString("PASSWORD", ""));
        }
        //如果上次登录选了自动登录，那进入登录页面也自动勾选自动登录,填上用户名和密码并
        if(chooseAutoLogin){
            autologinCkb.setChecked(true);
            userName=sp.getString("USER_NAME","");
            password=sp.getString("PASSWORD","");
//            usernameTxt.setText(userName);
//            passwordTxt.setText(password);
            if (userName.equals("abc")
                    && password.equals("123")) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }

    }
    public void checkLogin(View v){
        userName = usernameTxt.getText().toString();
        password = passwordTxt.getText().toString();
        SharedPreferences.Editor editor =sp.edit();

        if (userName.equals("abc")
                && password.equals("123")) {
            //保存用户名和密码
            editor.putString("USER_NAME", userName);
            editor.putString("PASSWORD", password);

            //是否自动登录
            if(autologinCkb.isChecked()){
                editor.putBoolean("remember", true);
                editor.putBoolean("autologin", true);
            }
            else if(rememberCkb.isChecked()){
                editor.putBoolean("remember", true);
                editor.putBoolean("autologin", false);
            }
            else {
                editor.putBoolean("remember", false);
                editor.putBoolean("autologin", false);
            }

            editor.commit();

            //跳转
            Intent intent =new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(LoginActivity.this, "用户名或密码错误，请重新登录!",
                    Toast.LENGTH_SHORT).show();
        }
    }

    class MyCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()){
                case R.id.autologin:
                    if(isChecked)
                        rememberCkb.setChecked(true);
                    break;
                case R.id.remember:
                    if(!isChecked)
                        autologinCkb.setChecked(false);
                    break;
                default:
                    break;
            }
        }
    }
}
