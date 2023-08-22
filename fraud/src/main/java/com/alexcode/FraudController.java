package com.alexcode;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fraud")
public class FraudController {

    private final FraudService fraudService;

    @GetMapping(path = "{customerId}")
    public FraudResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        log.info("customerId is {}", customerId);
        // boolean isFraudulent = fraudService.isFraudulent(customerId);
        boolean isFraudulent = fraudService.save(customerId).getIsFraudster();

        return new FraudResponse(isFraudulent);
    }

}