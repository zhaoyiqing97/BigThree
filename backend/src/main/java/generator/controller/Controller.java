package generator.controller;

import generator.service.MyThread;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.type.NullType;

import generator.domain.bo.ArticleInfoBO;
import generator.domain.common.CustomerUser;
import generator.domain.common.ResultData;
import generator.service.ArticleInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoyiqing
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class Controller {

    private final ArticleInfoService articleInfoService;

    @PostMapping("/publishArticle")
    public ResultData<NullType> publishArticle(@AuthenticationPrincipal CustomerUser customerUser,
                                               @RequestBody ArticleInfoBO bo) {
        articleInfoService.publishArticle(customerUser.getUserInfo().getId(), bo);
        return ResultData.success(null);
    }

    @GetMapping("/test")
    public ResultData test() {
        return ResultData.success("null");
    }
}
