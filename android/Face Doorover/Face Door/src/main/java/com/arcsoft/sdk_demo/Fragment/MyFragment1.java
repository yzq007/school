package com.arcsoft.sdk_demo.Fragment;

//import android.app.Fragment;
import android.content.ContentValues;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.arcsoft.sdk_demo.Application;
import com.arcsoft.sdk_demo.CodeActivity;
import com.arcsoft.sdk_demo.MainActivity;
import com.arcsoft.sdk_demo.R;
import com.arcsoft.sdk_demo.ShiwuzhaolingActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static android.content.ContentValues.TAG;

//v4.app.fragment与app.fragment不匹配会起冲突
public class MyFragment1 extends Fragment {
    ImageView code;
    private View mView;
    private ViewPager mViewPaper;
    private List<ImageView> images;
    private List<View> dots;
    private int currentItem;
    //记录上一次点的位置
    private int oldPosition = 0;
    //存放图片的id
    private int[] imageIds = new int[]{
            R.drawable.town,
            R.drawable.town1,
            R.drawable.town2,
            R.drawable.town3
    };
    //存放图片的标题
    private String[] titles = new String[]{
            "轮播1",
            "轮播2",
            "轮播3",
            "轮播4"
    };
    private ImageView scanning;
    private TextView title;
    private ViewPagerAdapter adapter;
    private ScheduledExecutorService scheduledExecutorService;
    private ListView listView;
    private static final int REQUEST_CODE_IMAGE_CAMERA = 1;
    public MyFragment1() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        setView();

        return mView;


    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        code = (ImageView) getActivity().findViewById(R.id.code);
        listView = (ListView) getActivity().findViewById(R.id.listview);
        scanning=(ImageView)getActivity().findViewById(R.id.scanning);
        SimpleAdapter simpleAdapter = new SimpleAdapter(
              getActivity(),
                getdata(),
                R.layout.list_item,
                new String[]{"image", "name", "info"},
                new int[]{R.id.image, R.id.nametv, R.id.infotv}
        );
        listView.setAdapter(simpleAdapter);
        //listview item事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Intent intent=new Intent(getActivity(), ShiwuzhaolingActivity.class);
              startActivity(intent);
//              getActivity().finish();
            }
        });
        Log.d("ttt", "getdata: "+getdata());
        code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent codeintent = new Intent(getActivity(), CodeActivity.class);
//                codeintent.putExtra("id",1);
                startActivityForResult(codeintent, 1);

            }
        });
      scanning.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");

              startActivityForResult(intent, REQUEST_CODE_IMAGE_CAMERA);
          }
      });
    }


    private  List<Map<String, Object>> getdata(){
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("image", R.drawable.dog);
        map.put("name", "失物招领");
        map.put("info", "浅色柯基，后背和屁股的毛夏天被剃短了看起来比肚子胸口尾巴上没剃刀的......");
        data.add(map);

        Map<String, Object> map1 = new HashMap<>();
        map1.put("image",R.drawable.bird);
        map1.put("name","菜鸟包裹");
        map1.put("info","【菜鸟驿站】您的申通****0828包裹已由快递超市代收，请携带学生证来......");
        data.add(map1);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("image",R.drawable.key);
        map2.put("name","失物招领");
        map2.put("info","本人于昨日下午在校门口捡到银色钥匙一串，失主请来3栋教学楼......");
        data.add(map2);
        return data;
    }

    private void setView(){
        Log.d("test", "setView: ");
        mViewPaper = (ViewPager)mView.findViewById(R.id.vp);
        //显示的图片
        images = new ArrayList<ImageView>();
        for(int i = 0; i < imageIds.length; i++){
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(imageIds[i]);
            images.add(imageView);
        }
        //显示的小点
        dots = new ArrayList<View>();
        dots.add(mView.findViewById(R.id.dot_0));
        dots.add(mView.findViewById(R.id.dot_1));
        dots.add(mView.findViewById(R.id.dot_2));
        dots.add(mView.findViewById(R.id.dot_3));


//        title = (TextView) getActivity().findViewById(R.id.title);
//        title.setText(titles[0]);
//
        adapter = new ViewPagerAdapter();
        mViewPaper.setAdapter(adapter);



        mViewPaper.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageSelected(int position) {
//                title.setText(titles[position]);
                dots.get(position).setBackgroundResource(R.drawable.dot_yes);
                dots.get(oldPosition).setBackgroundResource(R.drawable.dot_no);

                oldPosition = position;
                currentItem = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    /*定义的适配器*/
    public class ViewPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            // TODO Auto-generated method stub
//          super.destroyItem(container, position, object);
//          view.removeView(view.getChildAt(position));
//          view.removeViewAt(position);
            view.removeView(images.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            // TODO Auto-generated method stub
            view.addView(images.get(position));
            Log.d("123", "instantiateItem: "+view);
            return images.get(position);
        }

    }

    /**
     * 利用线程池定时执行动画轮播
     */
    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(
                new ViewPageTask(),
                2,
                2,
                TimeUnit.SECONDS);
        Log.d("123", "run: "+currentItem);
    }


    /**
     * 图片轮播任务
     * @author liuyazhuang
     *
     */
    private class ViewPageTask implements Runnable{

        @Override
        public void run() {
            currentItem = (currentItem + 1) % imageIds.length;
            mHandler.sendEmptyMessage(0);

            Log.d("123", "run: "+currentItem);

        }
    }

    /**
     * 接收子线程传递过来的数据
     */
    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {

            Log.d("test", "handleMessage: ");
            mViewPaper.setCurrentItem(currentItem);
//            Log.d("123", "handleMessage: "+mHandler);

        };
    };
    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        if(scheduledExecutorService != null){
            scheduledExecutorService.shutdown();
            scheduledExecutorService = null;
        }
    }

}
