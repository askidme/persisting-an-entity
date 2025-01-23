package com.codergm.sdj.auditor;

import org.springframework.data.domain.AuditorAware;

import java.util.List;
import java.util.Optional;
import java.util.Random;


public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(List.of("john21", "jane22", "joe23").get(new Random().nextInt(3)));
    }
}
