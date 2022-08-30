package generator;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.val;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("dev")
class ApplicationTest {

    @Autowired
    PasswordEncoder passwordEncoder;

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

    @Test
    void calculateTheDate() {
        Stream.of(
                LocalDate.of(1995, 11, 19),
                LocalDate.of(1996, 8, 15),
                LocalDate.of(1996, 12, 7)
        ).forEach(it -> {
            val datePlus = it.plusDays(10000);
            System.out.printf("from [%s];plus 1000 [%s];to now [%s] [%s]\n", it, datePlus, ChronoUnit.DAYS.between(it, LocalDate.now()), ChronoUnit.YEARS.between(it, LocalDate.now()));
        });
    }

    @Test
    void passwordTest() {
        System.out.println(passwordEncoder.encode("123456"));
    }

    @Test
    void stopWatch() throws InterruptedException {
        //start
        final StopWatch stopWatch = StopWatch.createStarted();
        final org.springframework.util.StopWatch stopWatchSpring = new org.springframework.util.StopWatch();

        // task1
        stopWatchSpring.start("task1");
        TimeUnit.SECONDS.sleep(1L);
        stopWatch.split();
        stopWatchSpring.stop();
        System.out.println(stopWatch.formatSplitTime());

        // task2
        stopWatchSpring.start("task2");
        TimeUnit.SECONDS.sleep(2L);
        stopWatch.split();
        stopWatchSpring.stop();
        System.out.println(stopWatch.formatSplitTime());

        // stop
        stopWatch.stop();
        System.out.println(stopWatchSpring.prettyPrint());
        System.out.println(stopWatch.formatTime());
    }
}
