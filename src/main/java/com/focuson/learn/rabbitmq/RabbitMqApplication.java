package com.focuson.learn.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * Created on 2018/3/27.
 *
 * @author guangsong.fan.
 */

@SpringBootApplication
@PropertySource(value = "classpath:application-${spring.profiles.active}.properties")
public class RabbitMqApplication {
    public static void main(String[] args) {
        if (null == System.getProperty("spring.profiles.active")) {
            System.setProperty("spring.profiles.active", "dev");
        }
        SpringApplication.run(RabbitMqApplication.class, args);
    }
}
