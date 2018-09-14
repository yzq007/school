package com.example.a16636.item;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 16636 on 2017/12/14.
 */

public class two extends Activity{
    ImageButton a1;
    ImageButton bill;
    ImageButton a3;
    ImageButton a4;
    ImageView imageView;
    private boolean isImage =true;
    TextView hidden;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two);
        bill=(ImageButton) findViewById(R.id.bill);
        a1=(ImageButton) findViewById(R.id.a1);
        a3=(ImageButton) findViewById(R.id.a3);
        a4=(ImageButton) findViewById(R.id.a4);
        imageView=(ImageView) findViewById(R.id.imageView);
        hidden=(TextView) findViewById(R.id.hidden);

        bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(two.this, com.example.a16636.item.bill.class);
                startActivity(intent1);
                finish();
            }
        });
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(two.this,main.class);
                startActivity(intent);
                finish();
            }
        });
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(two.this,three.class);
                startActivity(intent);
                finish();
            }
        });
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(two.this,four.class);
                startActivity(intent);
                finish();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isImage){
                    hidden.setVisibility(View.VISIBLE);
                    isImage=false;
                }else {
                    hidden.setVisibility(View.GONE);
                    isImage=true;
                }
            }
        });
    }
}
