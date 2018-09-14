package com.example.a16636.save;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.SimpleDateFormat;
import android.widget.EditText;

import java.util.Date;

/**
 * Created by 16636 on 2018/3/18.
 */

public class MySqliteOpenHelper extends SQLiteOpenHelper {
    //声明数据库名称
    private final static String DB_NAME="my.db";
    //声明版本号
    private final static int DB_VERSION=1;
    //声明数据表名称
    private final static String TBALE_NAME="info";
    public final static String Time="time";
    //声明内容
    public final static String CONTENT="content";
    //声明ID
    private final static String ID="_id";
    //声明SQL对象
    SQLiteDatabase datebase = getWritableDatabase();

    //参数一：上下文
    //参数二：数据库名
    //参数三：数据库工厂
    //参数四：版本号
    //参数五：数据库帮助对象
    public MySqliteOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    //创建数据表
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TBALE_NAME + "(" + ID
                + "  integer  primary key autoincrement," + CONTENT + " text,"+ Time +" time)");

    }

    //更新数据库
    //参数一：数据库对象
    //参数二：老的版本号
    //参数三：新的版本号
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
    //插入数据库
    public long insert(String text,String time){
        //实例化ContentValues
        ContentValues contentValues = new ContentValues();
        contentValues.put("content", text);
        contentValues.put("time",time);
        //定义对象表示用户插如的数据
        //参数一：表名
        //参数二：当我们的value数值为空的时候我们数据插入失败的时候会默认给一个Null，继续
        //向里面插入数据
        long row = datebase.insert(TBALE_NAME, null, contentValues);
        return row;
    }
    //修改数据的方法
    public void update(int _id,String text){
        //将数据修改过后再插入到数据表中
        ContentValues contentValues = new ContentValues();
        contentValues.put("content", text);
        //修改的方法
        //参数一：表名
        //参数二：数据对象
        //参数三/si：条件语句
        datebase.update(TBALE_NAME, contentValues, ID+"=?", new String[]{Integer.toString(_id)});
    }
    //删除数据的方法
    public void delete(int _id){
        datebase.delete(TBALE_NAME, ID+"=?",  new String[]{Integer.toString(_id)});
    }
    //查询数据的方法
    public Cursor select(){



        Cursor cursor = datebase.query(TBALE_NAME, null, null, null, null, null, null);
        return cursor;
    }



}