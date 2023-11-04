package com.example.demoredis.entites


data class HashCustomer(
    var Key: String?,
    var data: Customer?,
)

data class Customer(
    var id: String?,
    var name: String?,
    var age: Int?
)
