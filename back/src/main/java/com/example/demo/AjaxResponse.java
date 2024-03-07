package com.example.demo;

public class AjaxResponse {
    private Boolean isOk;
    private int code; // 200 400 500
    private String message;
    private Object object;

    public AjaxResponse(Boolean isOk, int code, String message) {
        this.isOk = isOk;
        this.code = code;
        this.message = message;
        this.object = object;
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

    public Boolean getOk() {
        return isOk;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getobject() {
        return object;
    }

    @Override
    public String toString() {
        return "AjaxResponse{" +
                "isOk=" + isOk +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", object=" + object +
                '}';
    }
}
