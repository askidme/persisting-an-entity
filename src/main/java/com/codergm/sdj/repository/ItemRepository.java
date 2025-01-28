package com.codergm.sdj.repository;

import com.codergm.sdj.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
