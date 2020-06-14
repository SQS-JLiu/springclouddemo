package org.example.springclouddemo.client;

import org.example.springclouddemo.CourseInfo;
import org.example.springclouddemo.CourseInfosRequest;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * 熔断降级策略
 */
@Component
public class CourseClientHystrix implements CourseClient{
    @Override
    public CourseInfo getCourseInfo(Long id) {
        //兜底策略，调用失败时返回一个无效对象
        return CourseInfo.invalid();
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
        return Collections.emptyList();
    }
}
