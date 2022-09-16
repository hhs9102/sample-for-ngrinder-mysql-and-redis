package com.example.sampleforngrindermysql.redis

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisPassword
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.StringRedisSerializer


@Configuration
class RedisConfig {
    @Value("\${spring.redis.host}")
    lateinit var redisHost: String

    @Value("\${spring.redis.password}")
    lateinit var redisPassword: String
    val redisPort = 6379

    @Bean
    fun redisConnectFactory(): RedisConnectionFactory {
        val redisStandaloneConfiguration = RedisStandaloneConfiguration()
        redisStandaloneConfiguration.hostName = redisHost
        redisStandaloneConfiguration.password = RedisPassword.of(redisPassword)
        redisStandaloneConfiguration.port = redisPort
        return LettuceConnectionFactory(redisStandaloneConfiguration)
    }

    @Bean
    fun redisTemplate(): RedisTemplate<String, String> {
        val redisTemplate = RedisTemplate<String, String>()
        redisTemplate.setConnectionFactory(redisConnectFactory())
        val stringRedisSerializer = StringRedisSerializer()
        redisTemplate.keySerializer = stringRedisSerializer
        redisTemplate.valueSerializer = stringRedisSerializer
        return redisTemplate
    }
}