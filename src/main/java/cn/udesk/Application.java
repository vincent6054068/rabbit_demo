package cn.udesk;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zjw
 * @date 2021/10/25 10:47
 */
@SpringBootApplication
@EnableRabbit
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
