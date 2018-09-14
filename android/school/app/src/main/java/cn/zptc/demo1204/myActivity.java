package cn.zptc.demo1204;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by jinshi on 2017/12/31.
 */

public class myActivity extends Activity{
    ImageButton bb;
    TextView xin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my);
        bb= (ImageButton) findViewById(R.id.bb);
        xin= (TextView) findViewById(R.id.xin);

        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent=new Intent(myActivity.this,MainActivity.class);
                startActivity(myintent);
                finish();
            }
        });

        xin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent xinintent=new Intent(myActivity.this,xinActivity.class);
                startActivity(xinintent);
                finish();
            }
        });
    }
}
