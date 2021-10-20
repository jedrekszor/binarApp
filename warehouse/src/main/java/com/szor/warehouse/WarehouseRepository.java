package com.szor.warehouse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class WarehouseRepository {

    private ArrayList<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1L, 50L, "apple", 2.2),
            new Product(2L, 5L, "oil", 10),
            new Product(3L, 20L, "beer", 3.5),
            new Product(4L, 30L, "banana", 1.4),
            new Product(5L, 200L, "fuel", 6.2),
            new Product(6L, 10L, "coffee", 30.3),
            new Product(7L, 8L, "meat", 10)
    ));

    public boolean checkIfAmountExists(Long id, Long amount) {
        Product product = products.stream()
                .filter(p -> p.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "No product with such id: " + id));

        return product != null && product.getAmount() >= amount;
    }

    public void buyProduct(Long id, Long amount) {
        products.stream()
                .filter(p -> p.getId().equals(id))
                .findAny()
                .ifPresent(product -> product.setAmount(product.getAmount() - amount));
    }

    public Product getProduct(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "No product with such id: " + id));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
