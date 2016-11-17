package com.gift.mygift.network;

/**
 * Author: Andecy
 * Time: 2016/4/21
 * Email: Andecy@foxmail.com
 * Description: 接口确认数据返回模板
 */
public class ApiResponse<T> {

    public int code;//错误代码
    public T data;//数据内容
    public String message;
}
