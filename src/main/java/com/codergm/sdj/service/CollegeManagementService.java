package com.codergm.sdj.service;

import com.codergm.sdj.entity.Guide;
import com.codergm.sdj.repository.GuideRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CollegeManagementService {

    private final GuideRepository guideRepository;

    @Transactional(readOnly = true)
    public void fetchingReadWriteGuide() {
        Guide guide = guideRepository.findById(1L).get();
        guide.setSalary(2500.00);
        guideRepository.save(guide);
    }
}
