package com.example.a16636.item;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 16636 on 2017/12/27.
 */

public class myview extends View{
    Path path;
    public myview(Context context) {
        super(context);
        path=new Path();

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



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

                path.moveTo(event.getX(),event.getY());
                break;
            case MotionEvent.ACTION_UP:

                break;
            case MotionEvent.ACTION_MOVE:

                path.lineTo(event.getX(),event.getY());
                invalidate();
                break;
            default:
                break;
        }
        return true;
    }
}
