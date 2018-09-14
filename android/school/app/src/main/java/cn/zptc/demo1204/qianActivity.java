package cn.zptc.demo1204;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class qianActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        MyView view=new MyView(this);
        setContentView(view);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("mylog", "onTouchEvent in MainActivity");
        return super.onTouchEvent(event);
    }
}
