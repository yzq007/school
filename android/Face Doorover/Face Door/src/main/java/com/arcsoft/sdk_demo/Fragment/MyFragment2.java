package com.arcsoft.sdk_demo.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.arcsoft.sdk_demo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFragment2 extends Fragment {
    private ListView list;
    public MyFragment2() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_coact,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list = (ListView) getActivity().findViewById(R.id.list);
        SimpleAdapter simple=new SimpleAdapter(
                getActivity(),
                gdata2(),
                R.layout.list2_item,
                new String[]{"image", "name", "info","img","text"},
                new int[]{R.id.im, R.id.natv, R.id.intv,R.id.image2,R.id.text}
        );
        list.setAdapter(simple);

    }
    private List<Map<String, Object>> gdata2(){
        List<Map<String, Object>> data2 = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("image", R.drawable.wu);
        map.put("name", "boss");
        map.put("info", "146475867");
        map.put("img",R.drawable.m);
        map.put("text","大队长");
        data2.add(map);

        Map<String, Object> map1 = new HashMap<>();
        map1.put("image",R.drawable.wu2);
        map1.put("name","强哥");
        map1.put("info","349382758");
        map1.put("img",R.drawable.m);
        map1.put("text","宿管");
        data2.add(map1);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("image",R.drawable.hao);
        map2.put("name","小陈");
        map2.put("info","12221324");
        map2.put("img",R.drawable.m);
        map2.put("text","好友");
        data2.add(map2);

        Map<String, Object> map3 = new HashMap<>();
        map3.put("image",R.drawable.hao);
        map3.put("name","另一个小陈");
        map3.put("info","1245868");
        map3.put("img",R.drawable.m);
        map3.put("text","好友");
        data2.add(map3);
        return data2;
    }
}