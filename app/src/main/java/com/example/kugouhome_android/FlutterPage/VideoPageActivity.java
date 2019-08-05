package com.example.kugouhome_android.FlutterPage;

import android.os.Bundle;
import android.util.Log;

import com.example.kugouhome_android.PageRouter;
import com.taobao.idlefish.flutterboost.containers.BoostFlutterActivity;

import java.util.Map;

import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class VideoPageActivity extends BoostFlutterActivity {
    private static final String TAG = "VideoPageActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onRegisterPlugins(PluginRegistry registry) {
        GeneratedPluginRegistrant.registerWith(registry);
    }

    @Override
    public Map getContainerParams() {
        return null;
    }

    @Override
    public String getContainerName() {
        return "KuGou://videoPage";
    }

    @Override
    public void destroyContainer() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Log.d(TAG, "onBackPressed: 返回");
    }
}
