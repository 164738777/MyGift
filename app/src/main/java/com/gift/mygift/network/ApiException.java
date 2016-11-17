package com.gift.mygift.network;

/**
 * Author: Andecy;
 * Time: 2016/4/21;
 * Email: Andecy@foxmail.com;
 * Description: 接口异常
 */
public class ApiException extends RuntimeException {
    private final String localMsg;
    private final int code;

    public ApiException(int code, String reason, String message) {
        super("errorCode->" + code + ",reason->" + reason + ",message->" + message);
        this.code = code;
        this.localMsg = reason;
    }

    public ApiException(int code, String message) {
        super("errorCode->" + code + ",message->" + message);
        this.code = code;
        this.localMsg = "";
    }

    public ApiException(String message) {
        super(message);
        localMsg = message;
        code = 0;
    }

    public String getCode() {
        return code + "";
    }

    @Override
    public String getLocalizedMessage() {
        return localMsg + "";
    }
}
