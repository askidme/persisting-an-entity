package com.codergm.sdj;

import com.codergm.sdj.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemTest {

    @Autowired
    private ItemService itemService;

    @Test
    void test_persist_item() {
        itemService.persistItem();
    }
}
