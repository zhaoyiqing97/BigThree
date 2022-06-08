package generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.Resource;

import generator.domain.ArticleType;
import generator.mapper.ArticleTypeMapper;

/**
 * @autuor zhaoyiqing
 */
@RestController
@MapperScan("generator.mapper")
public class Controller {
  @Resource ArticleTypeMapper articleTypeMapper;

  //  public Controller(ArticleTypeMapper articleTypeMapper) {
  //    this.articleTypeMapper = articleTypeMapper;
  //  }

  @GetMapping("/Test")
  public List<ArticleType> test() {
    return articleTypeMapper.selectList(null);
  }

  @GetMapping("/update")
  public void update() {}
}
