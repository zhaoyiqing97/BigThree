package generator.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import generator.domain.common.CustomerUser;
import generator.domain.common.ResultData;
import generator.domain.vo.UserInVO;
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
    public ResultData<UserInVO> loginSuccess(@AuthenticationPrincipal CustomerUser customerUser) {
        return ResultData.success(new UserInVO().from(customerUser.getUserInfo()));
    }
}
