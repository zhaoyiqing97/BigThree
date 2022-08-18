package generator.domain.common;

import lombok.Data;

/**
 * @author WangMingXin
 */
@Data
public class ResultData<T> {

    private Integer code;
    private String message;
    private T data;

    /**
     * 返回成功
     */
    public static <T> ResultData<T> success() {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(ResultCode.SUCCESS.getCode());
        resultData.setMessage(ResultCode.SUCCESS.getMessage());
        return resultData;
    }

    /**
     * 返回成功
     */
    public static <T> ResultData<T> success(T result) {
        ResultData<T> resultData = ResultData.success();
        resultData.setData(result);
        return resultData;
    }

    /**
     * 返回失败
     */
    public static <T> ResultData<T> error() {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(ResultCode.UNKNOWN_ERROR.getCode());
        resultData.setMessage(ResultCode.UNKNOWN_ERROR.getMessage());
        return resultData;
    }

    /**
     * 返回失败
     */
    public static <T> ResultData<T> error(T result) {
        ResultData<T> resultData = ResultData.error();
        resultData.setData(result);
        return resultData;
    }
}
