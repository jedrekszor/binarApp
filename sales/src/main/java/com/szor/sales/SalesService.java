package com.szor.sales;

import com.szor.policy.PolicyService;
import com.szor.warehouse.WarehouseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SalesService {

    private final WarehouseService warehouseService;
    private final PolicyService policyService;

    public String buyProduct(Long id, Long amount) {
        warehouseService.removeProduct(id, amount);
        double price = policyService.getPrice(id, amount);
        return "Sale complete, price: " + price;
    }
}