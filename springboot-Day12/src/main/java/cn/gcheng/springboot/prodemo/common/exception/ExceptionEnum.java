package cn.gcheng.springboot.prodemo.common.exception;

/**
 * 返回状态枚举类
 * @author GchengLiu
 */
public enum ExceptionEnum {
    /**
     * 添加异常类型代码与信息枚举
     */
    SUCCESS(0000, "请求成功"),
    FAIL(1000, "请求失败"),
    BODY_NOT_MATCH(1002,"请求的数据格式不符!"),
    NOT_FOUND(1004, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(1005, "服务器内部错误!"),
    SERVER_BUSY(1006,"服务器正忙，请稍后再试!");

    private Integer code;
    private String  msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg  = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
