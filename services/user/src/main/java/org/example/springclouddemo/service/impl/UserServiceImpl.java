package org.example.springclouddemo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.springclouddemo.CourseInfo;
import org.example.springclouddemo.CourseInfosRequest;
import org.example.springclouddemo.UserInfo;
import org.example.springclouddemo.client.CourseClient;
import org.example.springclouddemo.dao.UserCourseDao;
import org.example.springclouddemo.dao.UserDao;
import org.example.springclouddemo.entity.User;
import org.example.springclouddemo.entity.UserCourse;
import org.example.springclouddemo.service.IUserService;
import org.example.springclouddemo.vo.CreateUserRequest;
import org.example.springclouddemo.vo.UserCourseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 用户相关服务实现
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    public UserDao userDao;

    @Autowired
    public UserCourseDao userCourseDao;

    @Autowired
    public CourseClient courseClient;  //通过feign获取课程信息

    @Override
    public UserInfo createUser(CreateUserRequest request) {
        if (!request.validate()) {
            return UserInfo.invalid();
        }

        User oldUser = userDao.findByUsername(request.getUsername());
        if (null != oldUser) {
            return UserInfo.invalid();
        }

        User newUser = userDao.save(new User(
                request.getUsername(), request.getEmail()
        ));

        return new UserInfo(newUser.getId(), newUser.getUsername(), newUser.getEmail());
    }

    @Override
    public UserInfo getUserInfo(Long id) {
        Optional<User> user = userDao.findById(id);
        if (!user.isPresent()) {
            return UserInfo.invalid();
        }

        User curUser = user.get();
        return new UserInfo(curUser.getId(), curUser.getUsername(), curUser.getEmail());
    }

    @Override
    public UserCourseInfo getUserCourseInfo(Long id) {
        Optional<User> userOptional = userDao.findById(id);
        if (!userOptional.isPresent()) {
            return UserCourseInfo.invalid();
        }

        User user = userOptional.get();
        UserInfo userInfo = new UserInfo(user.getId(), user.getUsername(),
                user.getEmail());

        List<UserCourse> userCourses = userCourseDao.findAllByUserId(id);
        if (CollectionUtils.isEmpty(userCourses)) {
            return new UserCourseInfo(userInfo, Collections.emptyList());
        }

        List<CourseInfo> courseInfos = courseClient.getCourseInfos(
                new CourseInfosRequest(
                        userCourses.stream().map(UserCourse::getCourseId).collect(Collectors.toList())
                )
        );

        return new UserCourseInfo(userInfo, courseInfos);
    }
}
