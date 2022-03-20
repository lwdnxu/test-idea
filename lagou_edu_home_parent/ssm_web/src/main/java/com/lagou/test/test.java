package com.lagou.test;

import com.lagou.dao.CourseMapper;
import com.lagou.dao.TestMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class  )
@ContextConfiguration("classpath:applicationContext.xml")
public class test {
    @Autowired
    private TestMapper testMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseService courseService;
    @Test
    public void test1(){
        List<Course> all = courseService.findAll();
        System.out.println(all);
    }

    @Test
    public void test2(){
        CourseVO courseVO = new CourseVO();
        courseVO.setStatus(1);
        courseVO.setCourseName("文案");
        List<Course> courseByCondition = courseService.findCourseByCondition(courseVO);
        System.out.println(courseByCondition.size());
    }
}
