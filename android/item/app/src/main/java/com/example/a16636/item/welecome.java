package com.example.a16636.item;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 16636 on 2017/12/22.
 */

public class welecome extends Activity{
    TextView s;
    private int i=5;
    private  CountThread countThread = null;
    private Handler handler=null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welecome);
        s = findViewById(R.id.s);


//        Timer是一种定时器工具，用来在一个后台线程计划执行指定任务。它可以计划执行一个任务一次或反复多次。
//        TimerTask一个抽象类，它的子类代表一个可以被Timer计划的任务。

        final Intent it = new Intent(this, MainActivity.class); //你要转向的Activity
        final Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                timer.cancel();
                startActivity(it); //执行
                finish();
            }
        };
        timer.schedule(task, 5000);
        handler = new Handler();
        countThread = new CountThread();
        countThread.start();
    }

    private class CountThread extends Thread{
        public void run()
        {
            while(i > 0) {
                handler.post(runnableUi);
                //使用线程的方式实现倒计时
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    Runnable runnableUi = new  Runnable(){
        @Override
        public void run() {
            s.setText(i+"");
            i--;
        }
    };
}
