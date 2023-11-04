package com.example.demoredis

import com.example.demoredis.models.DeleteCustomerRequest
import com.example.demoredis.models.GetCustomerRequest
import com.example.demoredis.models.SaveCustomerRequest
import com.example.demoredis.models.UpdateCustomerRequest
import com.example.demoredis.service.CustomerService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class CustomerHandler(
    private val customerService: CustomerService
) {
    suspend fun save(request: ServerRequest) = request.awaitBody<SaveCustomerRequest>()
        .let {
            ServerResponse.ok().json().bodyValueAndAwait(customerService.saveCustomer(it))
        }

    suspend fun get(request: ServerRequest) = request.awaitBody<GetCustomerRequest>()
        .let {
            ServerResponse.ok().json().bodyValueAndAwait(customerService.getCustomer(it))
        }

    suspend fun update(request: ServerRequest) = request.awaitBody<UpdateCustomerRequest>()
        .let {
            ServerResponse.ok().json().bodyValueAndAwait(customerService.updateCustomer(it))
        }

    suspend fun delete(request: ServerRequest) = request.awaitBody<DeleteCustomerRequest>()
        .let {
            ServerResponse.ok().json().bodyValueAndAwait(customerService.deleteCustomer(it))
        }

    suspend fun getAll(request: ServerRequest) =
        ServerResponse.ok().json().bodyValueAndAwait(customerService.getAllCustomer())

}