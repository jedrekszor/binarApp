package com.szor.policy;

import com.szor.warehouse.Product;
import com.szor.warehouse.WarehouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PolicyService {

    private final WarehouseRepository warehouseRepository;
    private final PolicyRepository policyRepository;

    public double getPrice(Long id, Long amount) {
        Product product = warehouseRepository.getProduct(id);
        return calculatePrice(product.getAmount(), amount, product.getPrice());
    }

    private double calculatePrice(Long warehouseAmount, Long soldAmount, double basePrice) {
        Policy policy = policyRepository.getPolicy();
        double finalPrice = applyAmountModification(warehouseAmount, soldAmount, basePrice, policy);
        finalPrice = applyMarkup(warehouseAmount, soldAmount, finalPrice, policy);
        if (soldAmount > policy.getBulkDiscountAmount()) {
            finalPrice = applyBulkDiscount(finalPrice, policy);
        }
        return finalPrice;
    }

    private double applyAmountModification(Long warehouseAmount, Long soldAmount, double price, Policy policy) {
        // The less product the more it costs
        return 0;
    }

    private double applyBulkDiscount(double price, Policy policy) {
        return policy.getBulkDiscountPercentage() * price;
    }

    private double applyMarkup(Long warehouseAmount, Long soldAmount, double price, Policy policy) {
        // Markup
        return 0;
    }
}
