package generator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import generator.domain.ArticleType;
import generator.domain.common.ResultData;
import generator.service.ArticleTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

/**
 * @author zhaoyiqing
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class Controller {

    private final ArticleTypeService articleTypeService;

    @GetMapping("/list")
    public ResultData<List<ArticleType>> list() {
        val res = articleTypeService.selectAll();
        log.info("list res [{}]", res);
        return ResultData.success(res);
    }

    /**
     * 登录成功后重定向地址
     */
    @RequestMapping("/loginSuccess")
    public ResultData<String> loginSuccess() {
        return ResultData.success("登录成功");
    }
}
