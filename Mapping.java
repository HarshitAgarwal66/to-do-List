package com.todolist.todolist;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
@Configuration
public class Mapping {
    @Bean
    public Task task()
    {
        return new Task();
    }
    @Bean
    public User user()
    {
        return new User("","","");
    }
}
