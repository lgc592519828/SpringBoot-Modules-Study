package cn.gcheng.springboot.prodemo.common.result;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 请求返回数据格式
 * @param <T>
 * @author GchengLiu
 */
@Data
@NoArgsConstructor
public class Result<T> {
    private Integer code;
    private String resMsg;
    private String uri;
    private T data;

    public String toJson() {
        return this.data == null ? JSON.toJSONString(this) : this.toJson(SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteMapNullValue);
    }

    public String toJson(SerializerFeature... features) {
        return features == null ? this.toJson() : JSON.toJSONString(this, features);
    }

}
