package com.gift.mygift.network;

import rx.functions.Func1;


/**
 * 作者:  qiang on 2016/11/17 18:49
 * 邮箱:  anworkmail_q@126.com
 * 作用:  通用反馈模板,用来判断是否请求正常
 */

public class ApiFun<T> implements Func1<ApiResponse<T>, ApiResponse<T>> {
    @Override
    public ApiResponse<T> call(ApiResponse<T> tApiResponse) {
        int code = tApiResponse.code;
        String message = tApiResponse.message;
        if (code != 200 || !"OK".equals(message)) {
            throw new ApiException(code, message);
        }
        return tApiResponse;
    }
}
