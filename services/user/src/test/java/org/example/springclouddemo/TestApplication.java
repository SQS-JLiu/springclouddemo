package org.example.springclouddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 测试用例启动入口
 */
@SpringBootApplication
@EnableFeignClients(basePackages = {"org.example.springclouddemo"}) // 服务实现使用到了feign
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class,args);
    }
}
