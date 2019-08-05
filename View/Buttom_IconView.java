package com.example.kugouhome_android.View;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.kugouhome_android.R;

public class Buttom_IconView extends LinearLayout {
    private ImageView icon;
    private TextView name;
    private View view;
    private Drawable check;
    private Drawable unCheck;
    public Buttom_IconView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view= LayoutInflater.from(context).inflate(R.layout.buttom_iconview,this,true);
        icon=view.findViewById(R.id.bottom_iconview_image);
        name=view.findViewById(R.id.bottom_iconview_text);
    }
    //选中
    public void check(){
        icon.setImageDrawable(check);
        name.setTextColor(Color.parseColor("#01D6C4"));
    }
    //没选中
    public  void unCheck(){
        icon.setImageDrawable(unCheck);
        name.setTextColor(Color.parseColor("#000000"));
    }

    public void setData(Drawable check,Drawable unCheck,String name){
        this.check=check;
        this.unCheck=unCheck;
        this.name.setText(name);
    }

}
