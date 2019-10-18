package cn.gcheng.springboot.prodemo.common.result;

import cn.gcheng.springboot.prodemo.common.exception.ExceptionEnum;

import java.io.Serializable;

/**
 * 请求返回类
 * @author GchengLiu
 */
public class ResponseUtil implements Serializable {

    public static <T> Result<T> builderResponse(int code, String msg, String uri, T data) {
        Result<T> res = new Result();
        res.setCode(code);
        res.setResMsg(msg);
        res.setUri(uri);
        res.setData(data);
        return res;
    }

    /**
     * 添加常用方法
     */
    public static <T> Result<T> success(String msg,String uri) {
        return builderResponse(ExceptionEnum.SUCCESS.getCode(), msg, uri,null);
    }
    public static <T> Result<T> success(String msg,String uri, T data) {
        return builderResponse(ExceptionEnum.SUCCESS.getCode(), msg, uri, data);
    }
    public static <T> Result<T> success(String uri, T data) {
        return builderResponse(ExceptionEnum.SUCCESS.getCode(), ExceptionEnum.SUCCESS.getMsg(), uri, data);
    }
    public static <T> Result<T> success(String uri) {
        return builderResponse(ExceptionEnum.SUCCESS.getCode(), ExceptionEnum.SUCCESS.getMsg(), uri,null);
    }

    public static <T> Result<T> failure(String uri) {
        return builderResponse(ExceptionEnum.FAIL.getCode(), ExceptionEnum.FAIL.getMsg(), uri, null);
    }
    public static <T> Result<T> failure(String msg,String uri) {
        return builderResponse(ExceptionEnum.FAIL.getCode(), msg, uri, null);
    }
    public static <T> Result<T> failure(String uri, T date) {
        return builderResponse(ExceptionEnum.FAIL.getCode(), ExceptionEnum.FAIL.getMsg(),uri, date);
    }

    public static <T> Result<T> illegalRequest(String uri) {
        return builderResponse(ExceptionEnum.BODY_NOT_MATCH.getCode(), ExceptionEnum.BODY_NOT_MATCH.getMsg(),uri, null);
    }

    public static <T> Result<T> noHandlerException(String uri,T data) {
        return builderResponse(ExceptionEnum.NOT_FOUND.getCode(), ExceptionEnum.NOT_FOUND.getMsg(), uri, data);
    }

    public static <T> Result<T> serverException(String uri) {
        return builderResponse(ExceptionEnum.INTERNAL_SERVER_ERROR.getCode(), ExceptionEnum.INTERNAL_SERVER_ERROR.getMsg(),uri, null);
    }

    public static <T> Result<T> serverBusyException(String uri) {
        return builderResponse(ExceptionEnum.SERVER_BUSY.getCode(), ExceptionEnum.INTERNAL_SERVER_ERROR.getMsg(), uri,null);
    }

}
