package com.szor.warehouse;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
@AllArgsConstructor
public class WarehouseController {

    private final WarehouseRepository warehouseRepository;
    private final WarehouseService warehouseService;

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return warehouseRepository.getAllProducts();
    }

    @GetMapping("/getProduct")
    public Product getProduct(@RequestParam Long id) {
        return warehouseRepository.getProduct(id);
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product) {
        warehouseRepository.addProduct(product);
    }

    @DeleteMapping("/removeProduct")
    public void removeProduct(@RequestParam Long id, @RequestParam Long amount) {
        warehouseService.removeProduct(id, amount);
    }
}
