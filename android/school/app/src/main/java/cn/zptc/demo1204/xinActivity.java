package cn.zptc.demo1204;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by jinshi on 2017/12/31.
 */

public class xinActivity extends Activity{
    Button tv1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv1= (Button) findViewById(R.id.tv1);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(xinActivity.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(xinActivity.this,"已完成",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
