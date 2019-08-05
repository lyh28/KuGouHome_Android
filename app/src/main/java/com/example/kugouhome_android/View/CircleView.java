package com.example.kugouhome_android.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

public class CircleView extends AppCompatImageView {
    int r;
    int x;
    int y;
    Paint paint;
    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        r=Math.min(w,h)/2;
        x=w/2;
        y=h/2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.WHITE);
        canvas.drawCircle(x,y,r,paint);
        paint.setColor(Color.parseColor("#01D6C4"));
        canvas.drawCircle(x,y,r/6*5,paint);
        Path path=new Path();
        path.addCircle(x,y,r/6*5, Path.Direction.CCW);
        canvas.save();
        canvas.clipPath(path);
        super.onDraw(canvas);
        canvas.restore();
    }
}
