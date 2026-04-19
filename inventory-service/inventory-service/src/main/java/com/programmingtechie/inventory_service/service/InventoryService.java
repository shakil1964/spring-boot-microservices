package com.programmingtechie.inventory_service.service;


import com.programmingtechie.inventory_service.Repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode){
         return inventoryRepository.findBySkuCode(skuCode).map(inv -> inv.getQuantity() > 0).orElse(false);
    }
}
