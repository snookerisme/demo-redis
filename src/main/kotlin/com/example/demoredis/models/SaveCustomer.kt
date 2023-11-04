package com.example.demoredis.models

data class SaveCustomerRequest(
    val id: String,
    val name: String,
    val age: Int
)

data class SaveCustomerResponse(
    val id: String,
)