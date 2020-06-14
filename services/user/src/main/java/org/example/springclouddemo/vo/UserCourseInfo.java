package org.example.springclouddemo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springclouddemo.CourseInfo;
import org.example.springclouddemo.UserInfo;

import java.util.Collections;
import java.util.List;

/**
 * 用户课程信息对象定义
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCourseInfo {

    private UserInfo userInfo;
    private List<CourseInfo> courseInfos;

    public static UserCourseInfo invalid(){
        return new UserCourseInfo(UserInfo.invalid(), Collections.emptyList());
    }
}
