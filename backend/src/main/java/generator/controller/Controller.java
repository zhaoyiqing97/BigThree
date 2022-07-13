package generator.controller;

import generator.domain.UserInfo;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.*;

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
  public List<ArticleType> test() {
    return articleTypeService.selectAll();
  }

  /** 登录成功后重定向地址 */
  @RequestMapping("/loginSuccess")
  public String loginSuccess(){
    return "登录成功";
  }

}
