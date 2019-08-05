package com.example.kugouhome_android.FlutterPage;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kugouhome_android.PageRouter;
import com.taobao.idlefish.flutterboost.containers.BoostFlutterFragment;

import java.util.Map;

import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class HomePageFragment extends BoostFlutterFragment {
    private static final String TAG = "HomePageFragment";
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

        return "KuGou://homePage";
    }

    @Override
    public void destroyContainer() {

    }
}
