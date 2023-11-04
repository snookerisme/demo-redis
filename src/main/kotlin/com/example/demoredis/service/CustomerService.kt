package com.example.demoredis.service

import com.example.demoredis.dto.Response
import com.example.demoredis.entites.Customer
import com.example.demoredis.models.*
import com.example.demoredis.repositories.CustomerRepository
import org.springframework.stereotype.Service


@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) {

    suspend fun saveCustomer(saveCustomerRequest: SaveCustomerRequest): Response<SaveCustomerResponse> {
        customerRepository.saveCustomer(
            saveCustomerRequest.id,
            saveCustomerRequest.name,
            saveCustomerRequest.age
        )
        return Response(data = SaveCustomerResponse(saveCustomerRequest.id))
    }

    suspend fun getCustomer(getCustomerRequest: GetCustomerRequest):Response<Customer>{
        val responseData = customerRepository.getCustomer(getCustomerRequest.id)
        return Response(data = responseData)
    }

    suspend fun updateCustomer(updateCustomerRequest: UpdateCustomerRequest):Response<UpdateCustomerResponse>{
        customerRepository.updateCustomer(
            updateCustomerRequest.id,
            updateCustomerRequest.name,
            updateCustomerRequest.age
        )
        return Response(data = UpdateCustomerResponse(updateCustomerRequest.id))
    }

    suspend fun deleteCustomer(deleteCustomerRequest: DeleteCustomerRequest):Response<DeleteCustomerResponse>{
        customerRepository.deleteCustomer(deleteCustomerRequest.id)
        return Response(data = DeleteCustomerResponse(deleteCustomerRequest.id))
    }

    suspend fun getAllCustomer():Response<List<Customer>>{
        val responseData = customerRepository.getAllCustomer()
        return Response(data = responseData)
    }

}