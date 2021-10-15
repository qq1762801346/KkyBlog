package per.kky.demo.java8;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * JAVA8 新日期类
 */
public class DateDemo {

    @Test
    public void dateDemo() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("当前日期和时间: " + currentDateTime);
        System.out.println("当前日期: " + currentDateTime.toLocalDate());
        System.out.println("当前时间: " + currentDateTime.toLocalTime());

        // 转换类
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println(dtf.format(currentDateTime));
        String time = "2021-10-14 14:36";
        LocalDateTime tempTime = LocalDateTime.parse(time, dtf);
        System.out.println(tempTime);

        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
    }

}
