package com.example.a16636.item;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by 16636 on 2017/12/15.
 */

public class three extends Activity{
    ImageButton a1;
    ImageButton a2;
    ImageButton a4;
    ImageButton back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three);
        back=(ImageButton) findViewById(R.id.back);
        a1=(ImageButton) findViewById(R.id.a1);
        a2=(ImageButton) findViewById(R.id.a2);
        a4=(ImageButton) findViewById(R.id.a4);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(three.this,main.class);
                startActivity(intent);
                finish();
            }
        });
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(three.this,main.class);
                startActivity(intent);
                finish();
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(three.this,two.class);
                startActivity(intent);
                finish();
            }
        });
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(three.this,four.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
