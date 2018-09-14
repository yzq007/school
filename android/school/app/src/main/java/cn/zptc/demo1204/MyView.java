package cn.zptc.demo1204;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ydkf051 on 2017/11/22.
 */

public class MyView extends View {
    public static String TAG="mylog";
    Path path;
    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d(TAG, "MyView1: ");
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "MyView2: ");
        path=new Path();
    }

    public MyView(Context context) {
        super(context);
        path=new Path();
        Log.d(TAG, "MyView3: ");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        Paint p1=new Paint();
        p1.setStyle(Paint.Style.STROKE);
        p1.setStrokeWidth(8);
        p1.setColor(Color.RED);

        canvas.drawPath(path,p1);

//        Path path=new Path();
//        path.moveTo(50,50);
//        path.lineTo(250,50);
//        path.lineTo(100,200);
//        path.close();
//        canvas.drawPath(path,p1);


        ///RectF rec=new RectF(50,100,250,300);
        //canvas.drawRect(rec,p1);



//        Paint p2=new Paint();
//        p2.setColor(0xff00ff00);
//        p2.setStyle(Paint.Style.STROKE);
//        p2.setStrokeWidth(8);
//        p2.setAntiAlias(true);
//        canvas.drawCircle(300,400,200,p2);

//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog);
//        canvas.drawBitmap(bitmap,100,500,p2);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "onTouchEvent down x="+event.getX()+ ", y="+event.getY());
                path.moveTo(event.getX(),event.getY());
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "onTouchEvent up x="+event.getX()+ ", y="+event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "onTouchEvent move x="+event.getX()+ ", y="+event.getY());
                path.lineTo(event.getX(),event.getY());
                invalidate();
                break;
            default:
                break;
        }
        return true;
    }
}
