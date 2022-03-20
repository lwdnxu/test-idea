package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;

import java.util.List;

public interface CourseContentService {
    //
    public List<CourseSection> findSectionAndLessonByCourseId(Integer id);
    public Course findCourseByCourseId(Integer id);
    public void saveSection(CourseSection section);
    public void updateSection(CourseSection section);
}
