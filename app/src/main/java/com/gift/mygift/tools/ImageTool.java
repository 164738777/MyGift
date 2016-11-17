package com.gift.mygift.tools;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * 作者:  qiang on 2016/11/17 21:09
 * 邮箱:  anworkmail_q@126.com
 * 作用:  图片工具类
 */

public class ImageTool {

    public static void loadImage(ImageView imageView, String path) {
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(GiftApp.getInstance())
                .load(path)
                //                .error()
                //                .placeholder()
                .dontAnimate()
                .into(imageView);
    }

}
