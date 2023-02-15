package com.demo03error;

public class ResponseWrapper {
    private String data;
    private int status;

    public PixelResult<String, Exception> unwrap() {
        PixelResult<String, Exception> result = null;
        if (status != 200 || data == null) {
            result = PixelResult.failureWrap(new Exception("abc"));
        } else {
            result = PixelResult.successWrap(data);
        }
        return result;
    }
}
