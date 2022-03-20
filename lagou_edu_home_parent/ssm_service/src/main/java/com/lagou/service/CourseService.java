package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CourseService {

    public List<Course> findCourseByCondition(CourseVO courseVO);
    public List<Course> findAll();
    //添加课程与讲师信息
    public void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;
    public List<CourseVO> findCourseById(Integer id);
    public void updateCourseOrTeacher(CourseVO courseVO);
    public void updateCourseStatus(Integer id,int status );

}
