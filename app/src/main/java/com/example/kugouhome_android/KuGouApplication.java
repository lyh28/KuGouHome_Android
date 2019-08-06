package com.example.kugouhome_android;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.taobao.idlefish.flutterboost.Debuger;
import com.taobao.idlefish.flutterboost.FlutterBoostPlugin;
import com.taobao.idlefish.flutterboost.interfaces.IPlatform;

import java.util.Map;

import io.flutter.app.FlutterApplication;

public class KuGouApplication extends FlutterApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        FlutterBoostPlugin.init(new IPlatform() {
            @Override
            public Application getApplication() {
                return KuGouApplication.this;
            }

            @Override
            public Activity getMainActivity() {
                if(MainActivity.sRef!=null)
                    return MainActivity.sRef.get();
                return null;
            }

            @Override
            public boolean isDebug() {
                return true;
            }

            @Override
            public boolean startActivity(Context context, String url, int requestCode) {
                Debuger.log("startActivity url="+url);
                return PageRouter.openPageByUrl(context,url);
            }

            @Override
            public Map getSettings() {
                return null;
            }
        });
    }
}
