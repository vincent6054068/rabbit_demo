package cn.udesk.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

/**
 * @author zjw
 * @date 2021/10/25 10:56
 */
@Data
@Configuration
public class RabbitConfig {

    private RabbitRegistry rabbitRegistry;

    public RabbitConfig() {
        super();
        rabbitRegistry = new RabbitRegistry();
        register();
    }



    public void register(){
        rabbitRegistry.register("ex1","queue1","bind1");
        rabbitRegistry.register("ex2","queue2","bind2");
        rabbitRegistry.register("ex3","queue3","bind3");
        rabbitRegistry.register("ex4","queue4","bind4");
        rabbitRegistry.register("ex5","queue5","bind5");
        RabbitMQConfig rabbitMqConfig = new RabbitMQConfig();
        rabbitRegistry.register(rabbitMqConfig.testDirectExchange(),rabbitMqConfig.testDirectQueue(),"router");
    }

}
