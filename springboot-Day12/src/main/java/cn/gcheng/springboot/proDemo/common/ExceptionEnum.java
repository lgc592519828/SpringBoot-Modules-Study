package cn.gcheng.springboot.proDemo.common;

public enum ExceptionEnum {
    SUCCESS("1001", "REQUEST_OK"),
    BODY_NOT_MATCH("1002","请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH("1003","请求的数字签名不匹配!"),
    NOT_FOUND("1004", "未找到该资源!"),
    INTERNAL_SERVER_ERROR("1005", "服务器内部错误!"),
    SERVER_BUSY("1006","服务器正忙，请稍后再试!");


    ExceptionEnum(String s1, String w) {

    }
}
