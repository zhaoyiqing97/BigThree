package generator.domain.common;

import lombok.Data;

/**
 * 异常类
 *
 * @author WangMingXin
 */
@Data
public class JsonResult {
    /**
     * 异常码
     */
    protected String code;

    /**
     * 异常信息
     */
    protected String msg;

    public JsonResult() {
        this.code = "200";
        this.msg = "操作成功";
    }

    public JsonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
