package com.focuson.learn.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Caching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 2018/3/27.
 *
 * @author guangsong.fan.
 */

@Configuration
public class RabbitmqConfig {

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private Integer port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchange, true, false);
    }

    @Bean
    public Queue queue() {
        return new Queue("", true);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with("");
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setHost(host);
        cachingConnectionFactory.setPort(port);
        cachingConnectionFactory.setUsername(username);
        cachingConnectionFactory.setPassword(password);
        cachingConnectionFactory.setVirtualHost(virtualHost);
        return cachingConnectionFactory;
    }
}
