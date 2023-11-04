package com.example.demoredis

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoRedisApplication

fun main(args: Array<String>) {
	runApplication<DemoRedisApplication>(*args)
}
