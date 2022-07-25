package generator;

import com.google.common.collect.Lists;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.val;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApplicationTest {

  @Test
  void contextLoads() {
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
}
