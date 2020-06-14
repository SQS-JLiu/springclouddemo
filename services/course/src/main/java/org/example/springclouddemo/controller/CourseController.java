package org.example.springclouddemo.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.example.springclouddemo.CourseInfo;
import org.example.springclouddemo.CourseInfosRequest;
import org.example.springclouddemo.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 课程对外服务接口
 */
@Slf4j
@RestController
public class CourseController {

    @Autowired
    private ICourseService courseService;


    //不通过网关直接访问  127.0.0.1:7001/course/get/course?id=
    //通过网关访问       127.0.0.1:9000/imooc/course/get/course?id=
    @GetMapping("/get/course")
    public CourseInfo getCourseInfo(Long id){
        log.info("< Course >: get course -> {}", id);
        return courseService.getCourseInfo(id);
    }

    /**
     *  获取课程信息
     * */
    @PostMapping("/get/courses")  // 127.0.0.1:7001/course/get/courses
    public List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request) {
        log.info("<Course>: get courses -> {}", JSON.toJSONString(request));
        return courseService.getCourseInfos(request);
    }

}
