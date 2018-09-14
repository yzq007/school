package com.example.a16636.save;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by 16636 on 2018/3/18.
 */

public class beiwan extends Activity implements View.OnClickListener {
    private Button okButton, cancleButton;
    private EditText contentWrite;
    // 声明数据库
    private MySqliteOpenHelper dbHelper;
    // 声明游标
    private Cursor cursor;
    // 声明字段id
    private int _id = 0;
    // 声明list
	/*private ListView list;*/
    ImageButton fanhui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beiwan);
        fanhui= (ImageButton) findViewById(R.id.fanhui);
//        sure= (Button) findViewById(R.id.sure);
//        content= (EditText) findViewById(R.id.content);
//        cancel= (Button) findViewById(R.id.cancel);
        init();
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(beiwan.this,main.class);
                startActivity(intent);
                finish();
            }
        });
    }



    private void init() {
        dbHelper = new MySqliteOpenHelper(
                this);
        // 得到游标
        cursor = dbHelper.select();
        // 得到实例
        okButton = (Button) findViewById(R.id.sure);
        cancleButton = (Button) findViewById(R.id.cancel);
        contentWrite = (EditText) findViewById(R.id.content);
        okButton.setOnClickListener(this);
        cancleButton.setOnClickListener(this);
        // 实例化listview
		/*list = (ListView) findViewById(R.id.lv_title);*/
		/*SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
				R.layout.listitem, cursor, new String[] { DBHelper.CONTENT },
				new int[] { R.id.tv_info });*/
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void addData() {
        // 首先判断数据是否为空
        if (contentWrite.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "文本框不能为空", Toast.LENGTH_SHORT).show();
        } else {
            // 插入数据
            SimpleDateFormat formatter = new SimpleDateFormat   ("yyyy/MM/dd/HH");
            Date curDate =  new Date(System.currentTimeMillis());
            dbHelper.insert(contentWrite.getText().toString(),formatter.format(curDate).toString());

            // 刷新游标
            cursor.requery();
            // 刷新list
            //	list.invalidateViews();
            // 赋值
            contentWrite.setText("");
            Toast.makeText(getApplicationContext(), "提交成功", Toast.LENGTH_SHORT).show();
            // 清零
            _id = 0;
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sure:
                addData() ;
                Intent intent = new Intent(this,main.class);
                startActivity(intent);
                finish();
                break;

            case R.id.cancel:
                Intent intent1 = new Intent(this,main.class);
                startActivity(intent1);
                finish();
                break;
        }

    }

}
