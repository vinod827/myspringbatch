package com.myspringbatch.demo.batch;

import com.myspringbatch.demo.model.User;
import com.myspringbatch.demo.repository.UserRepository;
import org.hibernate.annotations.SortComparator;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbWriter implements ItemWriter<User> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void write(List<? extends User> users) throws Exception {
        System.out.println("Saving User:"+users);
        userRepository.save(users);
    }
}
