package com.example.kugouhome_android;

import android.content.Context;
import android.content.Intent;

import com.example.kugouhome_android.FlutterPage.VideoPageActivity;

public class PageRouter {
    public static final String VIDEO_PAGE_URL = "KuGou://videoPage";
    public static boolean openPageByUrl(Context context, String url) {
        return openPageByUrl(context, url, 0);
    }

    public static boolean openPageByUrl(Context context, String url, int requestCode) {
        try {
            if (url.startsWith(VIDEO_PAGE_URL)) {
                context.startActivity(new Intent(context, VideoPageActivity.class));
                return true;
            } else {

                return false;
            }
        } catch (Throwable t) {
            return false;
        }
    }
}
