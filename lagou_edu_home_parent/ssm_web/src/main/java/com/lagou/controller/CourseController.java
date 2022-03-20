package com.lagou.controller;

import com.lagou.domain.*;
import com.lagou.service.CourseContentService;
import com.lagou.service.CourseService;
import com.lagou.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private TestService testService;


    @RequestMapping("/findCourseByCondition")
    public ResponseResult findCourseByCondition(@RequestBody CourseVO courseVO){ // 这里会吧前端传过来的CourseVO对象进行封装
        List<Course> courseByCondition = courseService.findCourseByCondition(courseVO);
        ResponseResult responseResult = new ResponseResult();
        responseResult.setState(courseVO.getStatus());
        responseResult.setSuccess(true);
        responseResult.setContent(courseByCondition);
        responseResult.setMessage("相应成功");
        return responseResult;
    }


    @RequestMapping("/findAll")
    public List<Course> findAll(){
        return courseService.findAll();
    }

    @RequestMapping("/test")
    public List<Test> find(){
        return testService.findAllTest();
    }

    @RequestMapping("/courseUpload")
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
//        // 1. 判断接受到的上传文件是否为空
//        if(file.isEmpty()){
//            throw new RuntimeException();
//        }
//
//        // 2. 获取项目的部署路径
//        //
//        // 智利我们只需要 \ssm_web
//        String realPath = request.getServletContext().getRealPath("/");
//        String substring = realPath.substring(0, realPath.indexOf("ssm_web"));
//
//        // 3. 获取源文件名
//        String originalFilename = file.getOriginalFilename();
//
//
//        // 4. 生成新文件名
//        String newFilePath = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));
//
//        // 5. 文件上传
//        String uploadPath = substring + "upload\\";
//        File filePath = new File(uploadPath, newFilePath);
//
//        // 6. 目录不存在则创建目录
//        if(!filePath.getParentFile().exists()){
//            filePath.getParentFile().mkdirs(); // 不存在则创建目录
//            System.out.println("创建目录" + filePath);
//        }
//
//        // 图片则上传
//        file.transferTo(filePath);
//        Map<String, String> map = new HashMap<>();
//
//        map.put("fileName",newFilePath);
//        map.put("filePath"," http://localhost:8080/upload/"+newFilePath);
//        ResponseResult responseResult = new ResponseResult(true, 200, "上传成功", map);
//
//        return responseResult;

        try {
//1.判断文件是否为空
            if(file.isEmpty()){
                throw new RuntimeException();
            }
//2.获取项目部署路径
// D:\apache-tomcat-8.5.56\webapps\ssm_web\
            String realPath = request.getServletContext().getRealPath("/");
// D:\apache-tomcat-8.5.56\webapps\
            String webappsPath =
                    realPath.substring(0,realPath.indexOf("ssm_web"));
            //3.获取原文件名
            String fileName = file.getOriginalFilename();
//4.新文件名
            String newFileName = System.currentTimeMillis() +
                    fileName.substring(fileName.lastIndexOf("."));
//5.上传文件
            String uploadPath = webappsPath+"upload\\";
            File filePath = new File(uploadPath,newFileName);
//如果目录不存在就创建目录
            if(!filePath.getParentFile().exists()){
                filePath.getParentFile().mkdirs();
                System.out.println("创建目录: " + filePath);
            }
            file.transferTo(filePath);
//6.将文件名和文件路径返回
            Map<String,String> map = new HashMap<>();
            map.put("fileName",newFileName);
            map.put("filePath","http://localhost:8080/"+"upload/"+newFileName);
            System.out.println(123);
            ResponseResult result = new ResponseResult(true,200,"响应成功",map);
            return result;
        } catch (Exception e) {
            System.out.println(123);
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/upload")
    public String fileUpload1(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        return file.getOriginalFilename();
    }

    @RequestMapping("/saveOrUpdateCourse")  //RequestBody是获取到请求体中的内容
    public ResponseResult saveOrUpdateCourse(@RequestBody CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        ResponseResult responseResult =null;
        if(courseVO.getId()!=null){
            courseService.saveCourseOrTeacher(courseVO);
             responseResult = new ResponseResult(true, 200, "新增成功", null);

        }
        else{
            courseService.updateCourseOrTeacher(courseVO);
             responseResult = new ResponseResult(true, 200, "修改成功", null);
        }

        return responseResult;

    }

    @RequestMapping("/findCourseById")
    public ResponseResult findCourseById(Integer id){
        List<CourseVO> courseById = courseService.findCourseById(id);

        ResponseResult responseResult = new ResponseResult(true, 200, "相应成功", courseById);
        return responseResult;
    }


    @RequestMapping("/updateCourseStatus")
    public ResponseResult updateCourseStatus(Integer id, int  status){
        courseService.updateCourseStatus(id,status);
        Map<String, Integer> map = new HashMap<>();
        map.put("status",status);
        ResponseResult responseResult = new ResponseResult(true, 200, "相应成功", map);
        return responseResult;

    }


}
