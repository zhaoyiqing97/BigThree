package generator.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import generator.domain.ArticleInfo;
import generator.domain.ArticleType;
import generator.domain.common.ResultData;
import generator.service.ArticleInfoService;
import generator.service.ArticleTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

/**
 * NoAuthController.
 *
 * @author 刘斌
 * @version 0.0.1
 * @serial 2022-08-15 : base version.
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("no-auth")
public class NoAuthController {

    private final ArticleTypeService articleTypeService;

    private final ArticleInfoService articleInfoService;


    @GetMapping("article-type/list")
    public ResultData<List<ArticleType>> articleTypeList() {
        val res = articleTypeService.selectAll();
        return ResultData.success(res);
    }

    @GetMapping("article-info/page")
    public ResultData<Page<ArticleInfo>> articleInfoPage(Pageable pageable) {
        val res = articleInfoService.page(pageable);
        return ResultData.success(res);
    }
}
