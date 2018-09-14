package com.example.a16636.save;

import android.app.Activity;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.sql.Time;
import java.util.Date;

/**
 * Created by 16636 on 2018/3/25.
 */

public class BillActivity extends Activity{
    LinearLayout threetab;
    LinearLayout onetab;
    TextView time2,time;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bill);
        threetab= (LinearLayout) findViewById(R.id.threetab);
        onetab=(LinearLayout) findViewById(R.id.onetab);
        time2=(TextView) findViewById(R.id.time2);
        onetab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BillActivity.this,main.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
                finish();
            }
        });
        threetab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BillActivity.this,jisuanqi.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
                finish();
            }


        });
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd/ HH");
        Date date = new Date(System.currentTimeMillis());
        time2.setText(""+simpleDateFormat.format(date));
    }
}
