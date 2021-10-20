package com.szor.warehouse;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public void canBuy(Long id, Long amount) {
        if (!warehouseRepository.checkIfAmountExists(id, amount)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Not enough product");
        }
    }

    public void buyProduct(Long id, Long amount) {
        warehouseRepository.buyProduct(id, amount);
    }

    public void removeProduct(Long id, Long amount) {
        canBuy(id, amount);
        buyProduct(id, amount);
    }
}
