package com.example.a16636.item;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by 16636 on 2017/12/16.
 */

public class four extends Activity{
    ImageButton set;
    ImageButton a1;
    ImageButton a2;
    ImageButton a3;
    TextView lookbutton;
    LinearLayout draw;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four);
        set=(ImageButton) findViewById(R.id.set);
        a1=(ImageButton) findViewById(R.id.a1);
        a2=(ImageButton) findViewById(R.id.a2);
        a3=(ImageButton) findViewById(R.id.a3);
        lookbutton=(TextView) findViewById(R.id.lookbutton);
        draw=(LinearLayout) findViewById(R.id.draw);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(four.this,my.class);
                startActivity(intent);
                finish();
            }
        });

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(four.this,main.class);
                startActivity(intent);
                finish();
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(four.this,two.class);
                startActivity(intent);
                finish();
            }
        });
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(four.this,three.class);
                startActivity(intent);
                finish();
            }
        });
      draw.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent inten=new Intent(four.this,drawActivity.class);
              startActivity(inten);
          }
      });
        lookbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.baidu.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                Toast.makeText(four.this,"正在跳转",Toast.LENGTH_LONG).show();
            }
        });
    }
}
