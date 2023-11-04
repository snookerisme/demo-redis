package com.example.demoredis.models

data class DeleteCustomerRequest(
    val id: String
)

data class DeleteCustomerResponse(
    val id: String,
)