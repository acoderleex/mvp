package com.example.tony.mvp.http.exceptions;

/**
 * Created by Tony on 7/8/16.
 */
public class HttpApiException extends RuntimeException {

    public static final int USER_NOT_EXIST = 0x000001;

    protected HttpApiException(int code) {
        this(getLocalApiExceptionMessage(code));
    }

    public HttpApiException(String msg) {
        super(msg);
    }

    protected static String getLocalApiExceptionMessage(int code) {
        String msg = "未知错误";
        switch (code) {
            case USER_NOT_EXIST:
                msg = "用户不存在";
                break;
        }
        return msg;
    }
}
