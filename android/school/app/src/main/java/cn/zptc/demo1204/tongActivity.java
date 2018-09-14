package cn.zptc.demo1204;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by jinshi on 2017/12/31.
 */

public class tongActivity extends Activity{
    Button send;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiatiao);
        send= (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(tongActivity.this);
                builder.setTitle("提示");
                builder.setMessage("你确定要发送吗");
                builder.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      Intent intent=new Intent(tongActivity.this,MainActivity.class);
                        startActivity(intent);
                      finish();
                    }
                });
                builder.setNegativeButton("取消",null);
                builder.show();
            }
        });
    }
}
