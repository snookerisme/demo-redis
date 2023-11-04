package com.example.demoredis.utils

object RedisKey {

    fun buildCustomerKey() = "CUSTOMER::DEMO"

    fun buildCustomerHashKey(
        id: String
    ) = "CUSTOMER::${id}"

}