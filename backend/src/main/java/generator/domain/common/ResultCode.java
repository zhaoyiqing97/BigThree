package generator.domain.common;

/**
 * @author WangMingXin
 * @DATE 2022.7.1 七月请对我好一点
 * */
public enum ResultCode {
    //成功
    SUCCESS(200,"成功"),

    //参数错误
    PARAM_INVALID(402, "参数输入错误"),

    //失败
    UNKNOWN_ERROR(500, "未知错误");;

    private int code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
