package com.example.a16636.item;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by 16636 on 2017/12/9.
 */

public class main extends Activity {
    ImageButton bill;
    ImageButton a2;
    ImageButton a3;
    ImageButton a4;
    EditText shou;
    EditText chu;
//    Button bo;
    LinearLayout pen;
    boolean ispause = false;
    boolean stop = false;
    MediaPlayer mediaPlayer;
    Button button3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        bill = (ImageButton) findViewById(R.id.bill);
        a2 = (ImageButton) findViewById(R.id.a2);
        a3 = (ImageButton) findViewById(R.id.a3);
        a4 = (ImageButton) findViewById(R.id.a4);
        shou = (EditText) findViewById(R.id.shou);
        chu = (EditText) findViewById(R.id.chu);
        pen = (LinearLayout) findViewById(R.id.pen);
        button3 = (Button) findViewById(R.id.button3);
//        bo = (Button) findViewById(R.id.bo);
        mediaPlayer = MediaPlayer.create(this, R.raw.a);
        mediaPlayer.start();
        bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(main.this, com.example.a16636.item.bill.class);
                startActivity(intent1);
                finish();
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(main.this, two.class);
                startActivity(intent);
                finish();
            }
        });
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(main.this, three.class);
                startActivity(intent);
                finish();
            }
        });
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(main.this, four.class);
                startActivity(intent);
                finish();
            }
        });
        pen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = shou.getText().toString();
                String cont = chu.getText().toString();


                if (content.length() > 0 || cont.length() > 0) {
                    Intent intent = new Intent(main.this, com.example.a16636.item.bill.class);
                    Bundle bundle = new Bundle();
                    intent.putExtra("content", content);
                    intent.putExtra("cont", cont);
                    Toast.makeText(main.this, "已记录", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                    finish();
                } else {

                    Toast.makeText(main.this, "记录失败", Toast.LENGTH_LONG).show();

                }

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ispause == false) {
                    mediaPlayer.pause();
                    button3.setText("start");
                    ispause = true;
                } else {

                    button3.setText("stop");
                    ispause = false;
                    mediaPlayer.start();
                }
            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                //完成后重新播放
                mediaPlayer.start();
            }
        });
//        bo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mediaPlayer.stop();
//                play();
//            }
//        });

    }

//    private void play() {
//        mediaPlayer.stop();
//        mediaPlayer.reset();
//        mediaPlayer = MediaPlayer.create(this, R.raw.a);
//        mediaPlayer.start();
//    }
}
