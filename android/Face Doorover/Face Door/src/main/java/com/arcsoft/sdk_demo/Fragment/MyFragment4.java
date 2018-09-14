package com.arcsoft.sdk_demo.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.arcsoft.sdk_demo.DActivity;
import com.arcsoft.sdk_demo.DetecterActivity;
import com.arcsoft.sdk_demo.MainActivity;
import com.arcsoft.sdk_demo.R;

public class MyFragment4 extends Fragment {
    LinearLayout myfive;
    public MyFragment4() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_my,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myfive=(LinearLayout) getActivity().findViewById(R.id.myfive);
        myfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), DActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }
}