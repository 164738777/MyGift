package com.gift.mygift.network.subscriber;

/**
 * Author: Andecy;
 * Time: 2016/4/27;
 * Email: Andecy@foxmail.com;
 * Description: 请求时需要展示Loading Dialog的订阅
 */
/*public abstract class LoadingSubscriber<T> extends CommonSubscriber<T> {
    private Context mContext;
    private SweetAlertDialog mDialog;
    private String successToast;
    private String errorToast;

    public LoadingSubscriber(Context context) {
        this(context, R.string.loading);
    }

    *//**
     * @param res 自定义Loading内容
     *//*
    public LoadingSubscriber(Context context, @StringRes int res) {
        mContext = context;
        mDialog = DialogTool.getLoadingDialog(mContext, mContext.getString(res));
        mDialog.show();
        mDialog.setCancelable(false);
    }

    public LoadingSubscriber(Context context, String successToast) {
        this(context);
        this.successToast = successToast;
    }

    public LoadingSubscriber(Context context, String successToast, String errorToast) {
        this(context, successToast);
        this.errorToast = errorToast;
    }

    @Override
    public void onCompleted() {
        mDialog.dismiss();
        if (!TextUtils.isEmpty(successToast)) {
            ToastTool.show(mContext, successToast);
        }
    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
        mDialog.dismiss();
        if (mContext == null) {
            return;
        }
        if (e instanceof HttpException) {
            ToastTool.show(mContext, mContext.getString(R.string.load_fail_api));
        } else if (e instanceof SocketTimeoutException) {
            ToastTool.show(mContext, mContext.getString(R.string.load_fail_timeout));
        } else if (e instanceof ApiException) {
            ToastTool.show(mContext, e.getLocalizedMessage());
        } else if (!TextUtils.isEmpty(errorToast)) {
            ToastTool.show(mContext, errorToast);
        }
    }
}*/
