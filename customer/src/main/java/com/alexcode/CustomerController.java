package com.alexcode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {

    @PostMapping
    public Customer registerCustomer(@RequestBody CustomerReqest customerReqest) {
        log.info("new customer registration {}", customerReqest);

        return customerService.registerCustomer(customerReqest);
    }

    @GetMapping
    public String test() {
        return "Sample";
    }
}