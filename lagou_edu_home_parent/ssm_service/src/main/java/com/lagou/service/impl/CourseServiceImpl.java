package com.lagou.service.impl;

import com.lagou.dao.CourseMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseMedia;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;
import com.lagou.service.CourseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;
    @Override
    public List<Course> findCourseByCondition(CourseVO courseVO) {
        return courseMapper.findCourseByCondition(courseVO);
    }

    @Override
    public List<Course> findAll() {
        return courseMapper.findAll();
    }

    @Override
    public void saveCourseOrTeacher(CourseVO courseVO) throws IllegalAccessException, InvocationTargetException {
        // 封装课程信息
        Course course = new Course();
        // 这里不用全部调用set方法
        BeanUtils.copyProperties(course,courseVO);
        Date date = new Date();
        course.setCreateTime(new Date());
        course.setUpdateTime(new Date());
        courseMapper.saveCourse(course);

        // 获取新插入的id的值
        Integer id=  course.getId();

        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher,courseVO);
        teacher.setCreateTime(new Date());
        teacher.setUpdateTime(new Date());
        teacher.setId(0);
        teacher.setCourseId(id);
        // 保存讲师信息
        courseMapper.saveTeacher(teacher);

    }

    @Override
    public List<CourseVO> findCourseById(Integer id) {
         return courseMapper.findCourseById(id);
    }

    @Override
    public void updateCourseOrTeacher(CourseVO courseVO) {
        try {
            Course course = new Course();
            BeanUtils.copyProperties(course,courseVO);
            Date date = new Date();
            course.setUpdateTime(date);
            course.setCreateTime(date);
            courseMapper.updateCourse(course);


            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(teacher,courseVO);
            teacher.setCourseId(course.getId());
            teacher.setUpdateTime(date);
            teacher.setCreateTime(date);
            courseMapper.updateTeacher(teacher);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCourseStatus(Integer id, int status) {
        // 封装数据
        Course course = new Course();
        course.setId(id);
        course.setStatus(status);
        course.setUpdateTime(new Date());

        courseMapper.updateCourseStatus(course);

    }
}
