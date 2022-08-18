package generator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import generator.domain.ArticleInfo;

/**
 * ArticleInfoRepository.
 *
 * @author 刘斌
 * @version 0.0.1
 * @serial 2022-08-11 : base version.
 */
@Repository
public interface ArticleInfoRepository extends JpaRepository<ArticleInfo, Long> {

}
