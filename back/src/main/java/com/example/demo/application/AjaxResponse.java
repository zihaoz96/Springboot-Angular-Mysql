package com.example.demo.application;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AjaxResponse {
    private Boolean isOk;
    private int code; // 200 400 500
    private String message;
    private Object object;

    public AjaxResponse(Boolean isOk, int code, String message) {
        this.isOk = isOk;
        this.code = code;
        this.message = message;
        this.object = null;
    }
    public AjaxResponse(Boolean isOk, int code, String message, Object object) {
        this.isOk = isOk;
        this.code = code;
        this.message = message;
        this.object = object;
    }

    public static AjaxResponse success(String message){
        return new AjaxResponse(
                true,
                200,
                message
        );
    }

    public static AjaxResponse success(String message, Object o){
        return new AjaxResponse(
                true,
                200,
                message,
                o
        );
    }

    public static AjaxResponse failed(String message){
        return new AjaxResponse(
                false,
                400,
                message,
                null
        );
    }
}
