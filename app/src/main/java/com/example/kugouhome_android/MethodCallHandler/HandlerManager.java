package com.example.kugouhome_android.MethodCallHandler;

import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;

public class HandlerManager {
    private static HandlerManager singleton;
    private PluginRegistry pluginRegistry;
    private RouteHandler routeHandler;
    public static HandlerManager getSingleton(){
        if(singleton==null){
            synchronized (HandlerManager.class){
                if(singleton==null)
                    singleton=new HandlerManager();
            }
        }
        return singleton;
    }
    private HandlerManager(){
    }
    public void setRouteHandler(PluginRegistry registry){
        if(routeHandler==null)
            this.routeHandler=RouteHandler.registerWith(registry);
    }
    public RouteHandler getRouteHandler(){
        return routeHandler;
    }
}
