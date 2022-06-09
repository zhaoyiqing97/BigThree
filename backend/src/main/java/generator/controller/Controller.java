package generator.controller;

import org.springframework.web.bind.annotation.GetMapping;
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
  public List<ArticleType> test() {
    return articleTypeService.selectAll();
  }
}
