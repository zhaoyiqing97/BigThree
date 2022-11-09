package generator.domain.common;

import org.apache.skywalking.apm.toolkit.trace.TraceContext;

import lombok.Data;

/**
 * @author WangMingXin
 */
@Data
public class ResultData<T> {

  private Integer code;
  private String msg;
  private T data;
  private String traceId;

  /**
   * 返回成功
   */
  public static <T> ResultData<T> success() {
    ResultData<T> resultData = new ResultData<>();
    resultData.setCode(ResultCode.SUCCESS.getCode());
    resultData.setMsg(ResultCode.SUCCESS.getMessage());
    resultData.setTraceId(TraceContext.traceId());
    return resultData;
  }

  /**
   * 返回成功
   */
  public static <T> ResultData<T> success(T result) {
    ResultData<T> resultData = ResultData.success();
    resultData.setData(result);
    resultData.setTraceId(TraceContext.traceId());
    return resultData;
  }

  /**
   * 返回失败
   */
  public static <T> ResultData<T> error() {
    ResultData<T> resultData = new ResultData<>();
    resultData.setCode(ResultCode.UNKNOWN_ERROR.getCode());
    resultData.setMsg(ResultCode.UNKNOWN_ERROR.getMessage());
    resultData.setTraceId(TraceContext.traceId());
    return resultData;
  }

  /**
   * 返回失败
   */
  public static <T> ResultData<T> error(T result) {
    ResultData<T> resultData = ResultData.error();
    resultData.setData(result);
    resultData.setTraceId(TraceContext.traceId());
    return resultData;
  }
}
