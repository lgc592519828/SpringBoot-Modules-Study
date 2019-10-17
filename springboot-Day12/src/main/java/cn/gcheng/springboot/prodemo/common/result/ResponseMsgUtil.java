package cn.gcheng.springboot.prodemo.common.result;

import cn.gcheng.springboot.prodemo.common.exception.ExceptionEnum;

import java.io.Serializable;

/**
 * 请求返回类
 * @author GchengLiu
 */
public class ResponseMsgUtil implements Serializable {


    public static <T> Result<T> builderResponse(int code, String msg, T data) {
        Result<T> res = new Result();
        res.setCode(code);
        res.setResMsg(msg);
        res.setData(data);
        return res;
    }

    public static <T> Result<T> success(String msg) {
        return builderResponse(ExceptionEnum.SUCCESS.getCode(), msg, null);
    }
    public static <T> Result<T> success(String msg, T data) {
        return builderResponse(ExceptionEnum.SUCCESS.getCode(), msg, data);
    }
    public static <T> Result<T> success(T data) {
        return builderResponse(ExceptionEnum.SUCCESS.getCode(), ExceptionEnum.SUCCESS.getMsg(), data);
    }
    public static <T> Result<T> success() {
        return builderResponse(ExceptionEnum.SUCCESS.getCode(), ExceptionEnum.SUCCESS.getMsg(), null);
    }

    public static <T> Result<T> failure() {
        return builderResponse(ExceptionEnum.FAIL.getCode(), ExceptionEnum.FAIL.getMsg(), null);
    }
    public static <T> Result<T> failure(String msg) {
        return builderResponse(ExceptionEnum.FAIL.getCode(), msg, null);
    }
    public static <T> Result<T> failure(T date) {
        return builderResponse(ExceptionEnum.FAIL.getCode(), ExceptionEnum.FAIL.getMsg(), date);
    }

    public static <T> Result<T> illegalRequest() {
        return builderResponse(ExceptionEnum.BODY_NOT_MATCH.getCode(), ExceptionEnum.BODY_NOT_MATCH.getMsg(), (T) null);
    }

    public static <T> Result<T> noHandlerException() {
        return builderResponse(ExceptionEnum.NOT_FOUND.getCode(), ExceptionEnum.NOT_FOUND.getMsg(), (T) null);
    }

    public static <T> Result<T> serverException() {
        return builderResponse(ExceptionEnum.INTERNAL_SERVER_ERROR.getCode(), ExceptionEnum.INTERNAL_SERVER_ERROR.getMsg(), (T) null);
    }

    public static <T> Result<T> serverBusyException() {
        return builderResponse(ExceptionEnum.SERVER_BUSY.getCode(), ExceptionEnum.INTERNAL_SERVER_ERROR.getMsg(), (T) null);
    }

}
