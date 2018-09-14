package com.example.a16636.item;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by 16636 on 2017/12/15.
 */

public class bill extends Activity{
    ImageButton back;
    TextView sho;
    TextView zhichu;
    TextView yu;
    TextView tian;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bill);
        back=(ImageButton) findViewById(R.id.back);
        sho=(TextView) findViewById(R.id.sho);
        zhichu=(TextView) findViewById(R.id.zhichu);
        tian=(TextView) findViewById(R.id.tian);
        yu=(TextView) findViewById(R.id.yu);
         Intent intent=getIntent();
         String s=intent.getStringExtra("content");
         String c=intent.getStringExtra("cont");
        sho.setText(s);
        zhichu.setText(c);

        while (sho.getText().equals("")){
            sho.setText(""+100);
        }
        while (zhichu.getText().equals("")){
            zhichu.setText(""+50);
        }
        int y=Integer.parseInt(sho.getText().toString())-Integer.parseInt(zhichu.getText().toString());
        if (y>0){
            tian.setText("据系统显示您大概还能苟活"+(String.valueOf(y/50))+"天");
            yu.setText("还剩"+(String.valueOf(y))+"元");
        }else{
            tian.setText("系统没空搭理穷光蛋");
            yu.setText("负债情况:"+(String.valueOf(y)));
        }

//第三种：tv.setText(Integer.toString(num));数字的输入第二种：tv.setText(String.valueOf(num));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(bill.this,main.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
