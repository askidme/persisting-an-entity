package com.codergm.sdj.service;

import com.codergm.sdj.entity.Item;
import com.codergm.sdj.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    private final LoggingService loggingService;

    @Transactional(propagation = Propagation.NESTED)
    public void persistItem() {
        Item item = new Item(UUID.randomUUID().toString(), LocalDate.of(2022,5,1), 29);
        itemRepository.save(item);
        loggingService.logMessage("adding item with name: " + item.getName());
    }
}
