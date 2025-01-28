package com.codergm.sdj;

import com.codergm.sdj.service.CollegeManagementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GuideTest {

    @Autowired
    private CollegeManagementService collegeManagementService;

    @Test
    void test_fetching_read_write_guide(){
        collegeManagementService.fetchingReadWriteGuide();
    }
}
