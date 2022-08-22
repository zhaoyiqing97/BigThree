package generator.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import generator.domain.common.ResultData;
import generator.domain.vo.ArticleInfoVO;
import generator.domain.vo.ArticleTypeVO;
import generator.domain.vo.SearchVO;
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
    public ResultData<List<ArticleTypeVO>> articleTypeList() {
        val res = articleTypeService.selectAll()
                .stream()
                .map(it -> new ArticleTypeVO().from(it))
                .collect(Collectors.toList());
        return ResultData.success(res);
    }

    @GetMapping("article-info/page")
    public ResultData<Page<ArticleInfoVO>> articleInfoPage(Pageable pageable) {
        val res = articleInfoService.page(pageable)
                .map(it -> new ArticleInfoVO().from(it));
        return ResultData.success(res);
    }

    @GetMapping("article-info/search")
    public ResultData<List<SearchVO>> articleInfoSearch(String search) {
        return ResultData.success(articleInfoService.search(search));
    }

    @GetMapping("article-info/{id}")
    public ResultData<ArticleInfoVO> articleInfoGet(@PathVariable Long id) {
        return ResultData.success(
                articleInfoService.find(id)
                        .map(it -> new ArticleInfoVO().from(it))
                        .orElseThrow(() -> new RuntimeException("not found" + id))

        );
    }

}
