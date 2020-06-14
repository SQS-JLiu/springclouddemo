package org.example.springclouddemo.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.example.springclouddemo.UserInfo;
import org.example.springclouddemo.service.IUserService;
import org.example.springclouddemo.vo.CreateUserRequest;
import org.example.springclouddemo.vo.UserCourseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户服务对外接口
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/create/user")
    public UserInfo createUserInfo(@RequestBody CreateUserRequest request){
        log.info("< User >: create user -> {}", JSON.toJSONString(request));
        return userService.createUser(request);
    }

    //不通过网关直接访问  127.0.0.1:7000/user/get/user?id=
    //通过网关访问       127.0.0.1:9000/imooc/user/get/user?id=
    @GetMapping("/get/user")
    public UserInfo getUserInfo(Long id){
        log.info("< User >: get user -> {}",id);
        return userService.getUserInfo(id);
    }

    //不通过网关直接访问  127.0.0.1:7000/user/get/user/course?id=
    //通过网关访问       127.0.0.1:9000/imooc/user/get/user/course?id=
    @GetMapping("/get/user/course")
    public UserCourseInfo getUserCourseInfo(Long id){
        log.info("< User >: get user course info -> {}",id);
        return userService.getUserCourseInfo(id);
    }
}
