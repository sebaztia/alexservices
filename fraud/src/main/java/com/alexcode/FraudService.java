package com.alexcode;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudService {

    private final FraudRepository fraudRepository;

    public boolean isFraudulent(Integer customerId) {
        FraudCheckHistory fraudCheckHistory = fraudRepository.getById(customerId);

        return fraudCheckHistory.getIsFraudster();
    }

    public FraudCheckHistory save(Integer customerId) {
        return fraudRepository.save(FraudCheckHistory.builder()
                .customerId(customerId)
                .createdAt(LocalDateTime.now())
                .isFraudster(false)
                .build());
    }

}