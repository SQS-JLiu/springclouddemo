package org.example.springclouddemo.dao;

import org.example.springclouddemo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 表访问接口定义
 */
public interface CourseDao extends JpaRepository<Course, Long> {
}
