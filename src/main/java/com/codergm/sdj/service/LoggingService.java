package com.codergm.sdj.service;

import com.codergm.sdj.entity.Log;
import com.codergm.sdj.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoggingService {

    private final LogRepository logRepository;

    @Transactional
    public void logMessage(String message) {
        logRepository.save(new Log(message));
    }
}
