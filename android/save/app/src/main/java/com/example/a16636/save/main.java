package com.example.a16636.save;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Date;

import static android.content.ContentValues.TAG;

/**
 * Created by 16636 on 2018/3/12.
 */

public class main extends Activity implements View.OnClickListener{
    LinearLayout threetab;
    LinearLayout twotab;

    // 声明list

    private ListView list;
    private Cursor cursor;
    private MySqliteOpenHelper dbHelper;
    //声明字段id
    private int _id=0;

    ImageButton imageb;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        dbHelper = new MySqliteOpenHelper(this);
        cursor = dbHelper.select();
        imageb= (ImageButton) findViewById(R.id.btn_write);
        list=(ListView)findViewById(R.id.lv_title);
        imageb.setOnClickListener(this);
        Log.d(TAG, "onCreate: 11");

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.listitem, cursor,
                new String[]{dbHelper.CONTENT,dbHelper.Time}, new int[]{R.id.tv_info,R.id.time});
        //绑定适配器
        Log.d(TAG, "onCreate: 22");
        list.setAdapter(adapter);
        list.invalidateViews();
        Log.d(TAG, "onCreate: 33");
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                //查询方法
                cursor.moveToPosition(arg2);
                //如果没有查询到清零
                _id = cursor.getInt(0);
                //查询到了赋值
                //contentText.setText(cursor.getString(1));
                Intent intent = new Intent(main.this,Modify.class);
                intent.putExtra("id", _id);
                intent.putExtra("data", cursor.getString(1));
                startActivity(intent);
                finish();
            }
        });
        Log.d(TAG, "onCreate: 44");
        threetab= (LinearLayout) findViewById(R.id.threetab);
        twotab=(LinearLayout)findViewById(R.id.twotab);
        threetab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(main.this,jisuanqi.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
                finish();
            }


        });
        twotab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(main.this,BillActivity.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
                finish();
            }
        });

        Log.d(TAG, "onCreate: 55");
    }
    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.btn_write:
                Intent intent = new Intent(main.this,beiwan.class);
                startActivity(intent);
                finish();
                break;

            default:
                break;
        }


    }
}


