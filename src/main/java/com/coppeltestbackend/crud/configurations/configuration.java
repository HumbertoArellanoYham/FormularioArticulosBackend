package com.coppeltestbackend.crud.configurations;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.coppeltestbackend.crud.models.MultiplesFamilias;

@Configuration
@EnableWebMvc
public class configuration implements WebMvcConfigurer{

    // Redis cache 
    @Bean
    RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {

        RedisCacheConfiguration defaults = RedisCacheConfiguration.defaultCacheConfig()
            .entryTtl(Duration.ofMinutes(5))
            .enableTimeToIdle();

        return RedisCacheManager.builder(connectionFactory)
            .cacheDefaults(defaults)
            .build();
    }

    // Cors Configuration
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@SuppressWarnings("null") CorsRegistry registry) {;
                registry.addMapping("/**");
            }
       };
     }

     @Bean
     public MultiplesFamilias multiplesFamilias(){
        return new MultiplesFamilias();
     }
 }
