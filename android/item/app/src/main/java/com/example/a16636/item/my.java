package com.example.a16636.item;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * Created by 16636 on 2017/12/16.
 */

public class my extends Activity{

    ImageButton bb;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my);
        bb=(ImageButton) findViewById(R.id.bb);

        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(my.this,four.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
