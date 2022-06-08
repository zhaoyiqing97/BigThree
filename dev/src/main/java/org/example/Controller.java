package org.example;

import org.example.mapper.ArticleTypeMapper;
import org.example.pojo.ArticleType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

  final ArticleTypeMapper articleTypeMapper;

  public Controller(ArticleTypeMapper articleTypeMapper) {
    this.articleTypeMapper = articleTypeMapper;
  }

  @GetMapping("/Test")
  public List<ArticleType> test() {
    return articleTypeMapper.selectList(null);
  }

  @GetMapping("/update")
  public void update() {}
}
