package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.Test;
import com.lagou.service.CourseService;
import com.lagou.service.TestService;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController  // @Controller + ResponseBody
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @Autowired
    private CourseService courseService;

    @RequestMapping("/findAllTest")
    public List<Course> findAllTest(){
        return courseService.findAll();
    }

}
