package com.lagou.dao;


import com.lagou.domain.*;

import java.util.List;

public interface CourseMapper {
    public List<Course> findCourseByCondition(CourseVO courseVO);
    public List<Course> findAll();
    // 新增课程信息
    public void saveCourse(Course course);

    // 新增教师信息
    public void saveTeacher(Teacher teacher);

    // 根据id查询课程信息
    public List<CourseVO> findCourseById(Integer id);

    // 更新课程信息
    public void updateCourse(Course course);

    // 更新讲师信息
    public void updateTeacher(Teacher teacher);

    // 修改课程信息
    public void updateCourseStatus(Course course);

}
