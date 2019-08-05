package com.example.kugouhome_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import io.flutter.facade.Flutter;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.view.FlutterView;

public class VideoActivity extends AppCompatActivity {
    private static final String TAG = "lyh";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        initData();
        initFlutterView();
    }


    private void initData(){
        Intent intent=getIntent();
        Log.d(TAG, "initData: "+intent.getIntExtra("id",-1));
    }
    private void initFlutterView(){
        FlutterView view= Flutter.createView(this,getLifecycle(),"VideoPage");
        FrameLayout.LayoutParams layoutParams=new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        addContentView(view,layoutParams);
    }

}
