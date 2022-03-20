package com.lagou.test;

import com.lagou.dao.CourseContentMapper;
import com.lagou.dao.CourseMapper;
import com.lagou.dao.TestMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;
import com.lagou.domain.CourseVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class  )
@ContextConfiguration("classpath:applicationContext_service.xml")
public class test {
    @Autowired
    private TestMapper testMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseContentMapper courseContentMapper;

    @Test
    public void test1(){
        List<Course> all = courseMapper.findAll();
        System.out.println(all);
    }

    @Test
    public void test2(){
        List<CourseSection> sectionAndLessonByCourseId = courseContentMapper.findSectionAndLessonByCourseId(7);
        for (CourseSection courseSection : sectionAndLessonByCourseId) {
            System.out.println(courseSection);

        }
    }
}
