package com.guohua.xutils;

import android.app.Application;

import org.litepal.LitePalApplication;
import org.xutils.x;

/**
 * Created by 郭华 on 2017/8/3.
 */

public class myxutils extends LitePalApplication{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
