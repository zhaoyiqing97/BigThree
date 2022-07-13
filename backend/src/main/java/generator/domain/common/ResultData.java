package generator.domain.common;

/**
 * @author WangMingXin
 * @DATE 2022.7.1
 *
 * */
public class ResultData<T> {

    private Integer code;
    private String message;
    private T data;

    ResultData() {}

    /** 返回成功 */
    public static <T> ResultData<T> success() {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(ResultCode.SUCCESS.getCode());
        resultData.setMessage(ResultCode.SUCCESS.getMessage());
        return resultData;
    }

    /** 返回成功 */
    public static <T> ResultData<T> success(T result) {
        ResultData<T> resultData = ResultData.success();
        resultData.setData(result);
        return resultData;
    }

    /** 返回失败 */
    public static <T> ResultData<T> error() {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(ResultCode.UNKNOWN_ERROR.getCode());
        resultData.setMessage(ResultCode.UNKNOWN_ERROR.getMessage());
        return resultData;
    }

    /** 返回失败 */
    public static <T> ResultData<T> error(T result) {
        ResultData<T> resultData = ResultData.error();
        resultData.setData(result);
        return resultData;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
