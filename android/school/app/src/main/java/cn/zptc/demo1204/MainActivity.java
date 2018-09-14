package cn.zptc.demo1204;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by ydkf051 on 2017/12/25.
 */

public class MainActivity extends Activity {
    ImageButton tong;
    ImageButton xiao;
    ImageButton my;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhujiemian);
        tong = (ImageButton) findViewById(R.id.tong);
        xiao = (ImageButton) findViewById(R.id.xiao);
        my= (ImageButton) findViewById(R.id.my);
        tong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, tongActivity.class);
                startActivity(intent);
                finish();
            }
        });
      xiao.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent xiaointent=new Intent(MainActivity.this, xiaoActivity.class);
              startActivity(xiaointent);
              finish();
          }
      });
      my.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent myintent=new Intent(MainActivity.this,myActivity.class);
              startActivity(myintent);
              finish();
          }
      });
    }
}
