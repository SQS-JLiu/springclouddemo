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
 * Course实体表映射
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class) // 实现对数据表进行监听，在插入或更新数据时更新时间
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Basic // 标识这是表中的一个列，是默认的，该注解可以不显示标出来
    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "course_type", nullable = false)
    // 0 代表免费课程， 1代表实战课程
    private Integer courseType;

    @Column(name = "course_icon",nullable = false)
    private String courseIcon;

    @Column(name = "course_intro", nullable = false)
    private String courseIntro;

    @Column(name = "create_time",nullable = false)
    @CreatedDate
    private Date createTime;

    @Column(name = "update_time",nullable = false)
    @LastModifiedDate
    private Date updateTime;

    public Course(String courseName, Integer courseType,
                  String courseIcon, String courseIntro){
        this.courseName = courseName;
        this.courseType = courseType;
        this.courseIcon = courseIcon;
        this.courseIntro = courseIntro;
    }

    public static Course invalid(){
        Course course = new Course("",0,"","");
        course.setId(-1L);
        return course;
    }

}
