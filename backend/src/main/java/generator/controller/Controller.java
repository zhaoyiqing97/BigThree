package generator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import generator.domain.common.ResultData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoyiqing
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class Controller {

    /**
     * 登录成功后重定向地址
     */
    @RequestMapping("/loginSuccess")
    public ResultData<String> loginSuccess() {
        return ResultData.success("登录成功");
    }
}
