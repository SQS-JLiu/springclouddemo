package org.example.springclouddemo.service.impl;

import org.example.springclouddemo.CourseInfo;
import org.example.springclouddemo.CourseInfosRequest;
import org.example.springclouddemo.dao.CourseDao;
import org.example.springclouddemo.entity.Course;
import org.example.springclouddemo.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 课程服务功能实现
 */
@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public CourseInfo getCourseInfo(Long id) {
        Optional<Course> course = courseDao.findById(id);
        // 返回课程信息
        return buildCourseInfo(course.orElse(Course.invalid()));
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
        if(CollectionUtils.isEmpty(request.getIds())){
            return Collections.emptyList();
        }
        List<Course> courses = courseDao.findAllById(request.getIds());
        return courses.stream().map(this::buildCourseInfo).collect(Collectors.toList());
    }

    /**
     * 根据Course对象构造CourseInfo对象
     * @param course
     * @return
     */
    private CourseInfo buildCourseInfo(Course course) {

        return CourseInfo.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .courseType(course.getCourseType() == 0 ? "免费课程" : "实战课程")
                .courseIcon(course.getCourseIcon())
                .courseIntro(course.getCourseIntro())
                .build();
    }
}
