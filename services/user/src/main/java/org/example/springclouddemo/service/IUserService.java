package org.example.springclouddemo.service;

import org.example.springclouddemo.UserInfo;
import org.example.springclouddemo.vo.CreateUserRequest;
import org.example.springclouddemo.vo.UserCourseInfo;

/**
 * 用户相关服务接口定义
 */
public interface IUserService {

    // 创建用户
    UserInfo createUser(CreateUserRequest request);

    // 更具用户ID获取用户信息
    UserInfo getUserInfo(Long id);

    //获取用户和课程信息
    UserCourseInfo getUserCourseInfo(Long id);

}
