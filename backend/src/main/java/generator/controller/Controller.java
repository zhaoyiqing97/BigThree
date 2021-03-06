package generator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import generator.domain.ArticleType;
import generator.service.ArticleTypeService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

/**
 * @author zhaoyiqing
 */
@RestController
@Slf4j
public class Controller {

  private final ArticleTypeService articleTypeService;

  public Controller(ArticleTypeService articleTypeService) {
    this.articleTypeService = articleTypeService;
  }

  @GetMapping("/list")
  public List<ArticleType> list() {
    val res = articleTypeService.selectAll();
    log.info("list res [{}]", res);
    return res;
  }

  /** 登录成功后重定向地址 */
  @RequestMapping("/loginSuccess")
  public String loginSuccess() {
    return "登录成功";
  }
}
