package org.example.springclouddemo.dao;

import org.example.springclouddemo.entity.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * user_course表访问接口定义
 */
public interface UserCourseDao extends JpaRepository<UserCourse,Long> {

    public List<UserCourse> findAllByUserId(Long userId);
}
