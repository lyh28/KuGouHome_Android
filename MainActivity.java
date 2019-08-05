package com.example.kugouhome_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.example.kugouhome_android.View.Buttom_IconView;

import java.util.ArrayList;
import java.util.List;

import io.flutter.facade.Flutter;
import io.flutter.facade.FlutterFragment;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.view.FlutterView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String METHODCHANNEL_METHOD="TabRoute";       //通信的方法名
    private final String HOMEPAGE="HomePage";                   //路由名
    private final String ACTIONPAGE="ActionPage";
    private final String SONGPAGE="SongPage";
    private final String MEPAGE="MePage";

    private final String HOMEPAGENAME="首页";
    private final String ACTIONPAGENAME="动态";
    private final String SONGPAGENAME="好歌声";
    private final String MEPAGENAME="我的";

    private static final String TAG = "MainActivity";
    private List<Buttom_IconView> buttom_iconViews;
    private int tabIndex;

    private FrameLayout frameLayout;
    private FlutterView flutterView;
    private MethodChannel methodChannel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initUi();
        updateBottomLayout();
        setFlutterView(HOMEPAGE);
    }

    private void initData() {
        tabIndex = 0;
        buttom_iconViews = new ArrayList<>();
    }

    private void initUi() {
        Buttom_IconView home = findViewById(R.id.main_bottomlayout_home);
        Buttom_IconView action = findViewById(R.id.main_bottomlayout_action);
        View camera = findViewById(R.id.main_bottomlayout_camera);
        Buttom_IconView song = findViewById(R.id.main_bottomlayout_song);
        Buttom_IconView me = findViewById(R.id.main_bottomlayout_me);
        home.setData(getDrawble(R.drawable.star_green), getDrawble(R.drawable.star_gray), HOMEPAGENAME);
        action.setData(getDrawble(R.drawable.eye_green), getDrawble(R.drawable.eye_gray), ACTIONPAGENAME);
        song.setData(getDrawble(R.drawable.music_green), getDrawble(R.drawable.music_gray), SONGPAGENAME);
        me.setData(getDrawble(R.drawable.me_green), getDrawble(R.drawable.me_gray), MEPAGENAME);
        buttom_iconViews.add(home);
        buttom_iconViews.add(action);
        buttom_iconViews.add(song);
        buttom_iconViews.add(me);
        for (int i = 0; i < buttom_iconViews.size(); i++)
            buttom_iconViews.get(i).setOnClickListener(this);
    }

    private void setFlutterView(String page) {
        frameLayout=findViewById(R.id.main_framelayout);
        flutterView=Flutter.createView(this,getLifecycle(),"HomePage");
        frameLayout.addView(flutterView);
        methodChannel=new MethodChannel(flutterView,"com.lyh/flutter");
        methodChannel.setMethodCallHandler(new MethodChannel.MethodCallHandler() {
            @Override
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                switch (methodCall.method){
                    case "ToVideo":
                        Intent intent=new Intent(MainActivity.this,VideoActivity.class);
                        intent.putExtra("id",(int)methodCall.arguments);
                        startActivity(intent);
                        break;
                    case "SaveMore":
                        break;
                    case "SaveAll":
                        break;
                        default:
                            break;
                }
            }
        });
    }
    //更新底部Tab栏
    private void updateBottomLayout() {
        for (int i = 0; i < buttom_iconViews.size(); i++) {
            if (i == tabIndex)
                buttom_iconViews.get(i).check();
            else
                buttom_iconViews.get(i).unCheck();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_bottomlayout_home:
                tabIndex = 0;
                updateBottomLayout();
                methodChannel.invokeMethod(METHODCHANNEL_METHOD,HOMEPAGE);
                break;
            case R.id.main_bottomlayout_action:
                tabIndex = 1;
                updateBottomLayout();
                methodChannel.invokeMethod(METHODCHANNEL_METHOD,ACTIONPAGE);
                break;
            case R.id.main_bottomlayout_song:
                tabIndex = 2;
                updateBottomLayout();
                methodChannel.invokeMethod(METHODCHANNEL_METHOD,SONGPAGE);
                break;
            case R.id.main_bottomlayout_me:
                tabIndex = 3;
                updateBottomLayout();
                methodChannel.invokeMethod(METHODCHANNEL_METHOD,MEPAGE);
                break;
        }
    }

    //得到图片
    private Drawable getDrawble(int id) {
        return getResources().getDrawable(id);
    }

}
