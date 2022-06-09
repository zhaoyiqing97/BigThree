package generator.service;

import com.baomidou.mybatisplus.extension.service.IService;

import org.springframework.stereotype.Service;

import java.util.List;

import generator.domain.ArticleType;

/**
 * @author huawei
 * @description 针对表【article_type】的数据库操作Service
 * @createDate 2022-06-08 09:28:25
 */
@Service
public interface ArticleTypeService extends IService<ArticleType> {
  /**
   * selectAll
   *
   * @return list
   */
  List<ArticleType> selectAll();
}
