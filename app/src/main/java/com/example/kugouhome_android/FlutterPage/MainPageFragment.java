package com.example.kugouhome_android.FlutterPage;

import com.example.kugouhome_android.MethodCallHandler.HandlerManager;
import com.taobao.idlefish.flutterboost.containers.BoostFlutterFragment;

import java.util.Map;

import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainPageFragment extends BoostFlutterFragment {
    private static final String TAG = "MainPageFragment";
    @Override
    public void onRegisterPlugins(PluginRegistry registry) {
        GeneratedPluginRegistrant.registerWith(registry);
        HandlerManager.getSingleton().setRouteHandler(registry);
    }

    @Override
    public Map getContainerParams() {
        return null;
    }

    @Override
    public String getContainerName() {

        return "KuGou://MainPage";
    }

    @Override
    public void destroyContainer() {

    }
}
