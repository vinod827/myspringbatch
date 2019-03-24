package com.myspringbatch.demo.batch;

import com.myspringbatch.demo.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<User, User> {
    private static final Map<String, String> DEPT_NAME = new HashMap<>();

    public Processor() {
        DEPT_NAME.put("100", "Information Technology");
        DEPT_NAME.put("101", "Human Resources");
    }

    @Override
    public User process(User user) throws Exception {
        String deptCode = user.getDepartment();
        String departmant = DEPT_NAME.get(deptCode);
        user.setDepartment(DEPT_NAME.get(deptCode));
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime);

        //user.setLocalDateTime(localDateTime);
        user.setDate(new Date());
        System.out.println("Department conversion::"+departmant);
        return user;
    }
}
