package com.example.kugouhome_android.FlutterPage;

import com.example.kugouhome_android.PageRouter;
import com.taobao.idlefish.flutterboost.containers.BoostFlutterFragment;

import java.util.Map;

import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class ActionPageFragment extends BoostFlutterFragment {
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
        return "KuGou://actionPage";
    }

    @Override
    public void destroyContainer() {

    }
}
