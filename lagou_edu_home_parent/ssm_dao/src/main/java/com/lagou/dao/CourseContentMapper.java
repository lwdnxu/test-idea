package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;

import java.util.List;

public interface CourseContentMapper {

    public List<CourseSection> findSectionAndLessonByCourseId(Integer id);


    //
    public Course findCourseByCourseId(Integer id );
    public void saveSection(CourseSection section);
    public void updateSection(CourseSection section);
}
