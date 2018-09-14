package first.zptc.cn.qinyuan;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.doublewave.DoubleWaveView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    DoubleWaveView waveView;
    private GridView gridView;
    private ScheduledExecutorService scheduledExecutorService;
    private List<ImageView> images;
    private int[] imageIds = new int[]{
            R.drawable.town2,
            R.drawable.town1,
            R.drawable.town,
            R.drawable.town3
    };
    private int currentItem;
    private ViewPagerAdapter adapter;
    private ViewPager mViewPaper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        waveView = (DoubleWaveView) findViewById(R.id.waveView);
        waveView.setAnim(false);//默认是开启动画效果的，选false可关闭
        waveView.setAnim(true);//如果已经关闭，重新设置True开启动画
        setView();
        item();
    }
    private void setView(){
        Log.d("test", "setView: ");
        mViewPaper = (ViewPager)findViewById(R.id.vp);

        //显示的图片
        images = new ArrayList<ImageView>();
        for(int i = 0; i < imageIds.length; i++){
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(imageIds[i]);
            images.add(imageView);
        }



//        title = (TextView) getActivity().findViewById(R.id.title);
//        title.setText(titles[0]);
//
        adapter = new ViewPagerAdapter();
        mViewPaper.setAdapter(adapter);

        mViewPaper.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageSelected(int position) {
//                title.setText(titles[position]);

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
    public class ViewPagerAdapter extends PagerAdapter {

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
                5,
                3,
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





     private void item(){
            GridView gridview = (GridView) findViewById(R.id.gridview);
            Integer[] images = { R.drawable.icon,R.drawable.icon5,R.drawable.icon4};
         ArrayList<HashMap<String, Object>> meumList = new ArrayList<HashMap<String, Object>>();
         String[] mainmenu = { "","",""};

         for (int i = 0; i < mainmenu.length; i++) {
             HashMap<String, Object> map = new HashMap<String, Object>();
             map.put("ItemImage", images[i]);
             map.put("ItemText", mainmenu[i]);
             meumList.add(map);
         }
         SimpleAdapter saMenuItem = new SimpleAdapter(this, meumList,
                 R.layout.grid_view_item, new String[] { "ItemImage", "ItemText" },
                 new int[] { R.id.image_item, R.id.text_item });
         gridview.setAdapter(saMenuItem);
         gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                     long arg3) {
                 switch (arg2) {
                     case 0:
//                         Intent pendingIntent = new Intent(MainActivity.this,
//                                 PendingsActivity.class);
//                         startActivity(pendingIntent);
                         break;
                     case 1:
                         Intent pendingIntent = new Intent(MainActivity.this,
                                 MapActivity.class);
                         startActivity(pendingIntent);
                         break;
                     default:
                         break;
                 }
             }
         });
     }


}
