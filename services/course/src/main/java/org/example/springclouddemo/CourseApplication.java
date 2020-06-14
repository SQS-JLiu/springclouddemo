package org.example.springclouddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing    //JPA在更新数据库时会帮助我们更新数据表中的创建时间和更新时间
@EnableEurekaClient   //标识为一个eureka客户端，向eureka注册
public class CourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseApplication.class,args);
    }
}
