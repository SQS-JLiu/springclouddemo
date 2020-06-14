package org.example.springclouddemo.service;

import com.alibaba.fastjson.JSON;
import org.example.springclouddemo.CourseInfosRequest;
import org.example.springclouddemo.TestApplication;
import org.example.springclouddemo.dao.CourseDao;
import org.example.springclouddemo.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * 课程服务测试
 */
/**
 * {@link SpringBootTest}：配置文件属性的读取。读取classes标志的启动类的配置文件和运行环境，并加载。
 * {@link RunWith}：'RunWith'注解就是一个运行器，加载value的Class测试环境。
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CourseServiceTest {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private ICourseService courseService;

    //@Test
    public void testCreateCourseInfo(){  //执行插入数据到数据库
        Course course1 = new Course(
                "JDK11&12 新特性解读",
                0,
                "https://www.imooc.com/",
                "解读 JDK11 和 JDK12 的新版本特性"
        );
        Course course2 = new Course(
                "基于Spring Cloud微服务架构 广告系统设计与实现",
                1,
                "https://www.imooc.com/",
                "广告系统的设计与实现"
        );

        System.out.println(courseDao.saveAll(Arrays.asList(course1, course2)).size());
    }

    @Test
    public void testGetCourseInfo() {

        System.out.println(JSON.toJSONString(courseService.getCourseInfo(1L)));
        System.out.println(JSON.toJSONString(courseService.getCourseInfo(2L)));
    }

    @Test
    public void testGetCourseInfos() {

        System.out.println(JSON.toJSONString(courseService.getCourseInfos(
                new CourseInfosRequest(Arrays.asList(1L, 2L, 3L))
        )));
    }

}
