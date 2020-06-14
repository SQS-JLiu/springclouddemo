package org.example.springclouddemo.dao;

import org.example.springclouddemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * user数据表访问接口定义
 */
public interface UserDao extends JpaRepository<User,Long> {
    public User findByUsername(String username);
}
