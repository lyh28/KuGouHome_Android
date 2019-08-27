package com.example.kugouhome_android.MethodCallHandler;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;

public class RouteHandler implements MethodChannel.MethodCallHandler {
    private static MethodChannel methodChannel;
    @Override
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {

    }
    public static RouteHandler registerWith(PluginRegistry pluginRegistry){
        PluginRegistry.Registrar registrar=pluginRegistry.registrarFor("flutter.io/route");
        methodChannel=new MethodChannel(registrar.messenger(),"flutter.io/route");
        RouteHandler routeHandler=new RouteHandler();
        methodChannel.setMethodCallHandler(routeHandler);
        return routeHandler;
    }
    public static MethodChannel getMethodChannel(){
        return methodChannel;
    }
}
