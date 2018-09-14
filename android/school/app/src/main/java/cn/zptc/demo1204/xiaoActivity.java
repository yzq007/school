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

public class xiaoActivity extends Activity{
    ImageButton bbb;
    TextView weichuli;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shenqingjilu);
        bbb= (ImageButton) findViewById(R.id.bbb);
        weichuli= (TextView) findViewById(R.id.weichuli);
        bbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(xiaoActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        weichuli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent weiintent=new Intent(xiaoActivity.this,weiActivity.class);
                startActivity(weiintent);
                finish();
            }
        });
    }
}
