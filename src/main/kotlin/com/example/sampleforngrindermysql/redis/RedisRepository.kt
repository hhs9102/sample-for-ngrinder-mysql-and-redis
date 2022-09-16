package com.example.sampleforngrindermysql.redis

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

@Service
class RedisRepository(private val redisTemplate: RedisTemplate<String, String>) {
    fun testRedis(): String {
        val opsForValue = redisTemplate.opsForValue()
        return opsForValue.get("ngrinder")!!
    }
}