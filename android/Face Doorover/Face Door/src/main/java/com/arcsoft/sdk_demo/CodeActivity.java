package com.arcsoft.sdk_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.arcsoft.sdk_demo.Fragment.HomeActivity;
import com.arcsoft.sdk_demo.Fragment.MyFragment1;

public class CodeActivity extends Activity{
    ImageView back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        back=findViewById(R.id.back);
       Intent intent=getIntent();


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CodeActivity.this, HomeActivity.class);
                startActivity(intent);
               finish();
            }
        });
    }
}
