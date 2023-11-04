package com.example.demoredis.utils

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory
import org.springframework.data.redis.core.ReactiveRedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer

inline fun <reified T> ReactiveRedisConnectionFactory.buildReactiveRedisTemplate(): ReactiveRedisTemplate<String, T> =
    Jackson2JsonRedisSerializer(T::class.java).apply {
        setObjectMapper(
            jacksonObjectMapper()
                .registerModule(JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        )
    }.let {
        ReactiveRedisTemplate(
            this,
            RedisSerializationContext.newSerializationContext<String, T>(
                StringRedisSerializer()
            ).value(it).hashValue(it).build()
        )
    }