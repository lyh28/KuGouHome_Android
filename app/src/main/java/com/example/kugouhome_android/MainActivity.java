package com.example.kugouhome_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.example.kugouhome_android.FlutterPage.MainPageFragment;
import com.example.kugouhome_android.MethodCallHandler.RouteHandler;
import com.example.kugouhome_android.View.Buttom_IconView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static WeakReference<MainActivity> sRef;

    private final String HOMEPAGENAME = "首页";
    private final String ACTIONPAGENAME = "动态";
    private final String SONGPAGENAME = "好歌声";
    private final String MEPAGENAME = "我的";

    private static final String TAG = "MainActivity";
    private List<Buttom_IconView> buttom_iconViews;
    private int tabIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sRef = new WeakReference<>(this);
        setContentView(R.layout.activity_main);
        initData();
        initUi();
        updateBottomLayout();
        initFlutterView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sRef.clear();
        sRef = null;
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

    private void initFlutterView() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_framelayout,new MainPageFragment()).commit();
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
                if (tabIndex == 0)
                    return;
                tabIndex = 0;
                updateBottomLayout();
                RouteHandler.getMethodChannel().invokeMethod("ToHome",null);
                break;
            case R.id.main_bottomlayout_action:
                if (tabIndex == 1)
                    return;
                tabIndex = 1;
                updateBottomLayout();
                RouteHandler.getMethodChannel().invokeMethod("ToAction",null);
                break;
            case R.id.main_bottomlayout_song:
                if (tabIndex == 2)
                    return;
                tabIndex = 2;
                updateBottomLayout();
                RouteHandler.getMethodChannel().invokeMethod("ToSong",null);
                break;
            case R.id.main_bottomlayout_me:
                if (tabIndex == 3)
                    return;
                tabIndex = 3;
                updateBottomLayout();
                RouteHandler.getMethodChannel().invokeMethod("ToMe",null);

                break;
        }
    }

    //得到图片
    private Drawable getDrawble(int id) {
        return getResources().getDrawable(id);
    }

}
