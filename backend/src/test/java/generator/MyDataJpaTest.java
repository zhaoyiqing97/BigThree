package generator;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import generator.domain.ArticleInfo;
import generator.repository.ArticleInfoRepository;
import lombok.val;

/**
 * MyDataJpaTest.
 *
 * @author 刘斌
 * @version 0.0.1
 * @serial 2022-08-09 : base version.
 */
@DataJpaTest
@AutoConfigureMybatis
@ActiveProfiles("dev")
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MyDataJpaTest {

    @Autowired
    ArticleInfoRepository articleInfoRepository;

    @Test
    void insertArticleInfo() {
        val list = new ArrayList<ArticleInfo>();
        for (int i = 0; i < 100; i++) {
            val it = new ArticleInfo();
            it.setId(System.currentTimeMillis());
            it.setTitle(RandomStringUtils.random(50, true, true));
            it.setTypeId(RandomUtils.nextLong(1, 5));
            it.setAuthorId(1L);
            it.setReleaseTime(new Date());
            it.setVisitNum(RandomUtils.nextLong(10, 500));
            it.setCream(RandomUtils.nextInt(10, 500));
            it.setCommentNum(RandomUtils.nextInt(10, 500));
            it.setMarkdownContent(RandomStringUtils.random(500, true, true));
            it.setHtmlContent(RandomStringUtils.random(5000, true, true));
            it.setCreateTime(new Date());
            it.setCreateUser(1L);
            it.setIsDone(1);
            it.setPayKiss(0);
            it.setState(0);
            it.setStick(0);
            list.add(it);
        }
        articleInfoRepository.saveAll(list);
        System.out.println("articleInfoRepository.count() = " + articleInfoRepository.count());
    }

    @Test
    void groupByTop5Stream() {
        val all = articleInfoRepository.findAll();
        val res = StreamSupport.stream(all.spliterator(), false)
                .collect(Collectors.groupingBy(ArticleInfo::getTypeId,
                        Collectors.collectingAndThen(Collectors.toList(), ls -> ls.stream()
                                .sorted((o1, o2) -> o2.getVisitNum().compareTo(o1.getVisitNum()))
                                .limit(5)
                                .collect(Collectors.toList()))
                ));
        res.forEach((k, v) -> {
            System.out.printf("%s\n", k);
            v.forEach(it -> System.out.printf("%s %s \n", it.getId(), it.getVisitNum()));
        });
    }

}
