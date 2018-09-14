package com.arcsoft.sdk_demo.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.arcsoft.sdk_demo.R;
import com.arcsoft.sdk_demo.webdb.TransObjectToWeb;
import com.arcsoft.sdk_demo.webdb.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFragment3 extends Fragment {
    ListView passlist;
    ImageButton rite;
    public MyFragment3() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_pass,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        passlist=(ListView) getActivity().findViewById(R.id.passlist);
        rite=(ImageButton) getActivity().findViewById(R.id.rite);
        rite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {


                        User user = new User("张小凡","男",19);  //实例化用于测试的传输对象
                        TransObjectToWeb toWeb = new TransObjectToWeb();//实例化该类对象，调用其传输对象方法
                        boolean flag = toWeb.sendToWeb(user);
                        Log.d("TAG", "run: ");
                        if (flag) {
                            Looper.prepare();
                            Toast.makeText(getActivity(), "对象传输成功！", Toast.LENGTH_SHORT).show();
                            Looper.loop();
                        } else {
                            Looper.prepare();
                            Toast.makeText(getActivity(), "网络繁忙！", Toast.LENGTH_SHORT).show();
                            Looper.loop();
                        }
                    }
                }).start();
            }
        });
        SimpleAdapter passsimple=new SimpleAdapter(
          getActivity(),
          getpass(),
          R.layout.pass_list,
          new String[] {"name","cont","end"},
          new int[] {R.id.yezhu,R.id.content,R.id.jieguo}
        );
        passlist.setAdapter(passsimple);
    }

        private List<Map<String,Object>> getpass(){
        List<Map<String,Object>> data=new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("name","学生姓名：小杰");
        map.put("cont","远房表妹");
        map.put("end","正在审核...");

        data.add(map);

        Map<String, Object> map1 = new HashMap<>();
        map1.put("name","学生姓名：小杰");
        map1.put("cont","宠物狗");
        map1.put("end","未通过");
        data.add(map1);
        return data;
    }

//    public class setColorAdapter extends SimpleAdapter {
//        List<? extends Map<String, ?>> mdata;
//
//        public setColorAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from,
//                               int[] to) {
//            super(context, data, resource, from, to);
//            this.mdata = data;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            if (convertView == null) {
//                convertView = LinearLayout.inflate(getContext(), R.layout.pass_list, null);
//            }//这个TextView是R.layout.list_item里面的，修改这个字体的颜色
//            TextView textView = (TextView) getActivity().findViewById(R.id.jieguo);
//            //获取每次进来时 mData里面存的值  若果相同则变颜色
//            //根据Key值取出装入的数据，然后进行比较
//            String ss = (String) mdata.get(position).get("text");
//            Log.d("n", ss);
//            if (ss.equals("正在审核...")) {
//                textView.setTextColor(Color.rgb(00, 00, 255));
//            } else if (ss.equals("未通过")) {
//                textView.setTextColor(Color.RED);
//            }
//            //Log.i("TAG", Integer.toString(position));
//            //Log.i("TAG", (String) mData.get(position).get("text"));
//            return super.getView(position, convertView, parent);
//        }
//    }
}
