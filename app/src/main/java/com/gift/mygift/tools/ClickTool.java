package com.gift.mygift.tools;

/**
 * Created by Qiang on 2016/8/25.
 * 邮箱：anWorkMail_q@126.com
 * 作用：避免按钮重复点击事件,用在点击后弹toast的按钮
 */
public class ClickTool {

    // 判断按钮是否快速点击
    private static long lastClickTime = 0;

//    private static long clickGapTime = 0;

    public final static long TOAST_LONG = 3500;
    public final static long TOAST_MIDDLE = 3000;
    public final static long TOAST_SHORT = 2000;


    /**
     * 设置按钮点击间隔时间,默认为Toast.Long
     * <p>
     * //     * @param clickGapTime
     */
//    public static void setClickGapTime(long clickGapTime) {
//        ClickTool.clickGapTime = clickGapTime;
//    }
    public synchronized static boolean isFastClick() {
        return isFastClick(0);
    }

    public synchronized static boolean isFastClick(long clickGapTime) {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < (clickGapTime == 0 ? TOAST_LONG : clickGapTime)) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
}
