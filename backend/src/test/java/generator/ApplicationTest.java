package generator;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.val;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("dev")
class ApplicationTest {

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
    void mergeListStream() {
        val a = Lists.newArrayList("1", "2", "3");
        val b = Lists.newArrayList("4", "42", "43");
        val c = Stream.concat(a.stream(), b.stream()).collect(Collectors.toList());
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        assertEquals(Lists.newArrayList("1", "2", "3", "4", "42", "43"), c);
    }

    @Test
    void mergeListGuava() {
        val a = Lists.newArrayList("1", "2", "3");
        val b = Lists.newArrayList("4", "42", "43");
        val c = Lists.newArrayList(Iterables.concat(a, b));
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        assertEquals(Lists.newArrayList("1", "2", "3", "4", "42", "43"), c);
    }

    @Test
    void testRandomStringUtils() {
        for (int i = 0; i < 10; i++) {
            System.out.println(RandomStringUtils.random(50));
            System.out.println(RandomStringUtils.random(50, true, true));
        }
    }
}
