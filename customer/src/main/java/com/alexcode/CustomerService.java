package com.alexcode;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer registerCustomer(CustomerReqest reqest) {
        Customer customer = Customer.builder()
                .firstName(reqest.firstName())
                .lastName(reqest.lastName())
                .email(reqest.email())
                .build();

        customerRepository.saveAndFlush(customer);

       /* FraudResponse fraudResponse = restTemplate.getForObject("http://localhost:8081/api/v1/fraud/{customerId}",
                FraudResponse.class,
                customer.getId());

        if (fraudResponse.isFraudster()) {
            throw new IllegalStateException("fraudster customer");
        }*/
        return customer;
    }
}