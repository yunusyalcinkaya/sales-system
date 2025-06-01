package com.yunusyalcinkaya.catalogservice.configuration;

import com.yunusyalcinkaya.catalogservice.constant.RedisConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@EnableCaching
@Configuration
public class RedisConfig {

    @Value("${cache.redis.ttl.default}")
    private long defaultTimeToLive;

    @Value("${cache.redis.ttl.products}")
    private long timeToLiveForGettingAllProducts;

    @Bean
    public RedisCacheConfiguration defaultRedisConfiguration() {
        return RedisCacheConfiguration
                .defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(defaultTimeToLive))
                .disableCachingNullValues()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }

    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        return builder -> {
            // By creating multiple instances of the defined RedisCacheConfiguration, we can assign unique Time-To-Live (TTL) values to each cache name.
            RedisCacheConfiguration redisCacheConfigFotGettingAllProducts = RedisCacheConfiguration
                    .defaultCacheConfig()
                    .entryTtl(Duration.ofMinutes(timeToLiveForGettingAllProducts))
                    .disableCachingNullValues()
                    .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));

            builder.withCacheConfiguration(RedisConstant.ALL_PRODUCTS, redisCacheConfigFotGettingAllProducts);
        };
    }
}
