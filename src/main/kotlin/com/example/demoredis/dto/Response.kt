package com.example.demoredis.dto

import com.example.demoredis.utils.Constants.SUCCESS_CODE
import com.example.demoredis.utils.Constants.SUCCESS_DESC

data class Response<T> (
    val statusCode: String = SUCCESS_CODE,
    val statusDesc: String = SUCCESS_DESC,
    val data: T?
)
