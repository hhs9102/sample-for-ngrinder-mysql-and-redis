package com.example.sampleforngrindermysql

import com.example.sampleforngrindermysql.redis.RedisRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class SampleForNgrinderMysqlApplication

fun main(args: Array<String>) {
    runApplication<SampleForNgrinderMysqlApplication>(*args)
}


@RestController
class TestController(
    private val mysqlRepository: MysqlRepository,
    private val redisRepository: RedisRepository,
) {
    @GetMapping("/test/str")
    fun testStr() = "testString"

    @GetMapping("/test/mysql")
    fun testMysql() = mysqlRepository.findById(1)

    @GetMapping("/test/redis")
    fun testRedis() = redisRepository.testRedis()
}

