package com.arcsoft.sdk_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.arcsoft.sdk_demo.Fragment.HomeActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends Activity{
    private  CountThread countThread = null;
    ImageView ivGif;
    String TAG="1111";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);
        ivGif=(ImageView) findViewById(R.id.ivGif);
        //加载gif图片
        Glide.with(WelcomeActivity.this).load(R.drawable.timg)
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(ivGif);

//        Toast.makeText(WelcomeActivity.this, "人脸特征无法检测，请换一张图片", Toast.LENGTH_SHORT).show();

        final Intent it = new Intent(this, HomeActivity.class);
        final Timer timer = new Timer();

        Log.d(TAG, "onCreate: ");
        //        Timer是一种定时器工具，用来在一个后台线程计划执行指定任务。它可以计划执行一个任务一次或反复多次。
//        TimerTask一个抽象类，它的子类代表一个可以被Timer计划的任务。
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                timer.cancel();
                startActivity(it);
                //执行
                finish();
            }
        };
//        给timer定义三秒，三秒结束以后执行task取消timer这个函数，执行it跳转
        timer.schedule(task, 3000);

        countThread = new CountThread();
        countThread.start();
    }
    private class CountThread extends Thread{
        public void run()
        {
//            while(i > 0) {
//                handler.post(runnableUi);
            //使用线程的方式实现倒计时
            try {
                Thread.sleep(1000);
//       作用是延时，程序暂停若干时间，在执行时要抛出一个中断异常，必须对其进行捕获并处理才可以使用这个函数。
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
//            }
        }
    }
//    倒计时线程
//    Runnable runnableUi = new  Runnable(){
//        @Override
//        public void run() {
//            s.setText(i+"");
//            i--;
//        }
//    };

}
