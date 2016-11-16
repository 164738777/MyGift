package com.gift.mygift.network;

/**
 * Author: Andecy;
 * Time: 2016/4/21;
 * Email: Andecy@foxmail.com;
 * Description: 接口异常
 */
public class ApiException extends RuntimeException {
    private final String localMsg;
    private final String errorCode;

    public ApiException(String errorCode, String reason, String message) {
        super("errorCode->" + errorCode + ",reason->" + reason + ",message->" + message);
        this.errorCode = errorCode;
        this.localMsg = reason;
    }

    public ApiException(String message) {
        super(message);
        localMsg = message;
        errorCode = null;
    }

    public String getErrorCode() {
        return errorCode + "";
    }

    @Override
    public String getLocalizedMessage() {
        return localMsg + "";
    }
}
