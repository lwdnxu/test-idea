package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courseContent")
public class CourseContentController {

    @Autowired
    private CourseContentService courseContentService;

    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLesson(Integer courseId){
        List<CourseSection> sectionAndLessonByCourseId = courseContentService.findSectionAndLessonByCourseId(courseId);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", sectionAndLessonByCourseId);
        return responseResult;
    }

    @RequestMapping("/findCourseByCourseId")
    public ResponseResult findCourseByCourseId(Integer id){
        Course courseByCourseId = courseContentService.findCourseByCourseId(id);
        ResponseResult responseResult = new ResponseResult(true, 200, "相应成功", courseByCourseId);
        return responseResult;
    }

    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestBody CourseSection
                                                      section) {
            try {
//判断携带id是修改操作否则是插入操作
                if(section.getId() == null){
                    courseContentService.saveSection(section);
                    return new ResponseResult(true,200,"响应成功",null);
                }else{
                    courseContentService.updateSection(section);
                    return new ResponseResult(true,200,"响应成功",null);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

    }



}
