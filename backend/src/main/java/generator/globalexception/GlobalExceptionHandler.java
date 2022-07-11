package generator.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import generator.domain.JsonResult;
import lombok.extern.slf4j.Slf4j;

/**
 * 全局异常类
 *
 * @author WangMingXin
 */
@RestControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

  /**
   * 系统异常 预期以外异常
   *
   * @param ex Exception
   * @return JsonResult
   */
  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public JsonResult handleUnexpectedServer(Exception ex) {
    log.error("系统异常：", ex);
    ex.printStackTrace();
    return new JsonResult("500", "系统发生异常，请联系管理员");
  }

  /**
   * 缺少请求参数异常
   *
   * @param ex HttpMessageNotReadableException
   * @return JsonResult
   */
  @ExceptionHandler(MissingServletRequestParameterException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public JsonResult handleHttpMessageNotReadableException(
      MissingServletRequestParameterException ex) {
    log.error("缺少请求参数，{}", ex.getMessage());
    return new JsonResult("400", "缺少请求参数");
  }

  /**
   * 空指针异常
   *
   * @param ex NullPointerException
   * @return JsonResult
   */
  @ExceptionHandler(NullPointerException.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public JsonResult handleTypeMismatchException(NullPointerException ex) {
    log.error("空指针异常，{}", ex.getMessage());
    return new JsonResult("500", "空指针异常");
  }

  /**
   * 拦截业务异常，返回业务异常信息
   *
   * @param ex BusinessErrorException
   * @return JsonResult
   */
  @ExceptionHandler(BusinessErrorException.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public JsonResult handleBusinessError(BusinessErrorException ex) {
    String code = ex.getCode();
    String message = ex.getMessage();
    return new JsonResult(code, message);
  }
}
