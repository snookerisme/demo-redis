package com.example.demoredis.repositories

import com.example.demoredis.entites.Customer
import com.example.demoredis.utils.RedisKey
import com.example.demoredis.utils.buildReactiveRedisTemplate
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory
import org.springframework.data.redis.core.*
import org.springframework.stereotype.Repository

@Repository
class CustomerRepository(
    redisFactory: ReactiveRedisConnectionFactory,
) {

    private val redisTemplate = redisFactory.buildReactiveRedisTemplate<Customer>()

    internal suspend fun saveCustomer(id:String, name:String, age:Int) =
        redisTemplate
            .opsForHash<String,Customer>()
            .putAndAwait(
                key = RedisKey.buildCustomerKey(),
                hashKey = RedisKey.buildCustomerHashKey(id),
                hashValue = Customer(id,name,age),
            )

    internal suspend fun getCustomer(id:String) =
        redisTemplate
            .opsForHash<String,Customer>()
            .getAndAwait(
                key = RedisKey.buildCustomerKey(),
                hashKey = RedisKey.buildCustomerHashKey(id),
            )

    internal suspend fun updateCustomer(id:String,name:String, age:Int) =
        redisTemplate
            .opsForHash<String,Customer>()
            .putAndAwait(
                key = RedisKey.buildCustomerKey(),
                hashKey = RedisKey.buildCustomerHashKey(id),
                hashValue = Customer(id,name,age),
            )

    internal suspend fun deleteCustomer(id:String) =
        redisTemplate
            .opsForHash<String,Customer>()
            .removeAndAwait(
                key = RedisKey.buildCustomerKey(),
                hashKeys = *arrayOf(RedisKey.buildCustomerHashKey(id)),
            )

    internal suspend fun getAllCustomer() =
        redisTemplate
            .opsForHash<String,Customer>()
            .valuesAsFlow(key = RedisKey.buildCustomerKey())
            .map { it }
            .toList()

}