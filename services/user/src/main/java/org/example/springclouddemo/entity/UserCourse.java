package org.example.springclouddemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * user_course表对应实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user_course")
public class UserCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "user_id",nullable = false)
    private Long userId;

    @Column(name = "course_id",nullable = false)
    private Long courseId;

    @Column(name = "create_time",nullable = false)
    @CreatedDate
    private Date createTime;

    @Column(name = "update_time",nullable = false)
    @LastModifiedDate
    private Date updateTime;
}
