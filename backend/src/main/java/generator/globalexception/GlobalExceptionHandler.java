package generator.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.lang.model.type.NullType;

import generator.domain.common.ResultData;
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
     * @return generator.domain.common.ResultData
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<NullType> handleUnexpectedServer(Exception ex) {
        log.error("系统异常：", ex);
        return ResultData.error();
    }

    /**
     * 缺少请求参数异常
     *
     * @param ex HttpMessageNotReadableException
     * @return ResultData
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResultData<NullType> handleHttpMessageNotReadableException(
            MissingServletRequestParameterException ex) {
        log.error("缺少请求参数，{}", ex.getMessage());
        return ResultData.error();
    }

    /**
     * 空指针异常
     *
     * @param ex NullPointerException
     * @return ResultData
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<NullType> handleTypeMismatchException(NullPointerException ex) {
        log.error("空指针异常，{}", ex.getMessage());
        return ResultData.error();
    }

    /**
     * 拦截业务异常，返回业务异常信息
     *
     * @param ex BusinessErrorException
     * @return ResultData<>
     */
    @ExceptionHandler(BusinessErrorException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<NullType> handleBusinessError(BusinessErrorException ex) {
        final ResultData<NullType> res = ResultData.error();
        res.setMsg(ex.getMessage());
        return res;
    }
}
