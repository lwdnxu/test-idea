package com.lagou.service.impl;

import com.lagou.dao.CourseContentMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseContentServiceImpl implements CourseContentService {
    @Autowired
    private CourseContentMapper courseContentMapper;

    @Override
    public List<CourseSection> findSectionAndLessonByCourseId(Integer id) {
        return courseContentMapper.findSectionAndLessonByCourseId(id);
    }

    @Override
    public Course findCourseByCourseId(Integer id) {
        return courseContentMapper.findCourseByCourseId(id);
    }

    @Override
    public void saveSection(CourseSection section) {
        Date date = new Date();
        section.setCreateTime(date);
        section.setUpdateTime(date);
        courseContentMapper.saveSection(section);
    }

    @Override
    public void updateSection(CourseSection section) {
        Date date = new Date();
        section.setUpdateTime(date);
        courseContentMapper.updateSection(section);
    }
}
