package org.example.springclouddemo.service;

import com.alibaba.fastjson.JSON;
import org.example.springclouddemo.TestApplication;
import org.example.springclouddemo.dao.UserCourseDao;
import org.example.springclouddemo.entity.UserCourse;
import org.example.springclouddemo.vo.CreateUserRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * 用户服务测试用例
 */
// 通过@RunWith 和 @SpringBootTest启动spring容器
@RunWith(SpringRunner.class) //@RunWith就是一个运行器, 指定使用SpringRunner运行测试用例
@SpringBootTest(classes = {TestApplication.class}) //通过SpringApplication在测试中创建ApplicationContext,启动spring容器
public class UserServiceTest {

    @Autowired
    IUserService userService;

    @Autowired
    UserCourseDao userCourseDao;

    @Test
    //@Transactional // 如果你的测试是@Transactional，默认情况下它会在每个测试方法结束时回滚事务
    public void testCreateUser(){
        System.out.println(JSON.toJSONString(
                userService.createUser(new CreateUserRequest("zhansan","zhansan@qq.com"))
        ));
    }

    @Test
    public void getUserInfo(){
        System.out.println(JSON.toJSONString(userService.getUserInfo(2L)));
    }

    @Test
    public void testCreateUserCourse(){
        // 测试并向数据库中添加两条用户课程数据
        UserCourse userCourse1 = new UserCourse();
        userCourse1.setUserId(2L);
        userCourse1.setCourseId(1L);

        UserCourse userCourse2 = new UserCourse();
        userCourse2.setUserId(2L);
        userCourse2.setCourseId(2L);

        System.out.println(userCourseDao.saveAll(Arrays.asList(userCourse1,userCourse2)).size());
    }
}
