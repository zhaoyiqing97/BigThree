package generator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import generator.domain.ArticleType;
import generator.service.ArticleTypeService;

/**
 * @author zhaoyiqing
 */
@RestController
public class Controller {

  private final ArticleTypeService articleTypeService;

  public Controller(ArticleTypeService articleTypeService) {
    this.articleTypeService = articleTypeService;
  }

  @GetMapping("/list")
  public List<ArticleType> list() {
    return articleTypeService.selectAll();
  }

  /** 登录成功后重定向地址 */
  @RequestMapping("/loginSuccess")
  public String loginSuccess() {
    return "登录成功";
  }
}
