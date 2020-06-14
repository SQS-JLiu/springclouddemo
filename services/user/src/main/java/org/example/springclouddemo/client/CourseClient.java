package org.example.springclouddemo.client;

import org.example.springclouddemo.CourseInfo;
import org.example.springclouddemo.CourseInfosRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 通过Feign访问课程微服务
 */
// 根据服务名调用其他微服务
@FeignClient(name = "eureka-client-course", fallback = CourseClientHystrix.class)
public interface CourseClient {

    @GetMapping(value = "/course/get/course")
    CourseInfo getCourseInfo(Long id);

    @RequestMapping(value = "/course/get/courses",method = RequestMethod.POST)
    List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request);
}
