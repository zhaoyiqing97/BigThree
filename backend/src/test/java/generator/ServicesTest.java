package generator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import generator.service.ArticleInfoService;
import lombok.val;

/**
 * ServicesTest.
 *
 * @author 刘斌
 * @version 0.0.1
 * @serial 2022-08-18 : base version.
 */
@SpringBootTest
@ActiveProfiles("dev")
public class ServicesTest {
    @Autowired
    ArticleInfoService articleInfoService;

    @Test
    void test() {
        val res = articleInfoService.search("Content");
        System.out.println(res);
    }
}
