package com.gift.mygift.tools;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * 作者:  qiang on 2016/11/17 21:09
 * 邮箱:  anworkmail_q@126.com
 * 作用:  图片工具类
 */

public class ImageTool {

    /**
     * 加载普通图片
     *
     * @param imageView
     * @param path
     */
    public static void loadImage(ImageView imageView, String path) {
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(GiftApp.getInstance().getApplicationContext())
                .load(path)
                .crossFade()
                .dontAnimate()
                .into(imageView);
    }

    /**
     * 加载圆形边界
     *
     * @param imageView
     * @param path
     * @param radius
     * @param cornerType
     */
    public static void loadRoundBroadImage(Context context, ImageView imageView, String path, int radius, RoundedCornersTransformation.CornerType cornerType) {
        Glide.with(context)
                .load(path)
                .bitmapTransform(new CenterCrop(context))
                .bitmapTransform(
                        new RoundedCornersTransformation(context, radius, 0))
                .crossFade()
                .dontAnimate()
                .into(imageView);
    }


    /**
     * 不传类型就默认全角都圆形化
     *
     * @param imageView
     * @param path
     * @param radius
     */
    public static void loadRoundBroadImage(Context context, ImageView imageView, String path, int radius) {
        loadRoundBroadImage(context, imageView, path, radius, RoundedCornersTransformation.CornerType.ALL);
    }

    /**
     * 加载头像(圆形图)
     *
     * @param imageView
     * @param path
     */
    public static void loadCircleImage(Context context, ImageView imageView, String path) {
        Glide.with(context)
                .load(path)
                .bitmapTransform(new CropCircleTransformation(context))
                .crossFade()
                .dontAnimate()
                .into(imageView);
    }

}
