package cn.udesk.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author zjw
 * @date 2021/10/25 14:58
 */
@Component
public class RabbitBeanDefinition implements BeanDefinitionRegistryPostProcessor {

    private RabbitConfig rabbitConfig = new RabbitConfig();

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        RabbitRegistry rabbitRegistry = rabbitConfig.getRabbitRegistry();
        Map<String, Queue> queueMap = rabbitRegistry.getQueueMap();
        queueMap.forEach((s, queue) -> {
            BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Queue.class, () -> queue)
                    .getRawBeanDefinition();
            registry.registerBeanDefinition(s,beanDefinition);
        });
        rabbitRegistry.getExchangeMap().forEach((s, exchange) -> {
            BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Exchange.class, () -> exchange)
                    .getRawBeanDefinition();
            registry.registerBeanDefinition(s,beanDefinition);
        });
        rabbitRegistry.getBindingMap().forEach((s, binding) -> {
            BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Binding.class, () -> binding)
                    .getRawBeanDefinition();
            registry.registerBeanDefinition(s,beanDefinition);
        });
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
