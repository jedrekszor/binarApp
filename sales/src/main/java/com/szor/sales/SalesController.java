package com.szor.sales;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
@AllArgsConstructor
public class SalesController {

    private final SalesService salesService;

    @GetMapping("/buy")
    public String buy(@RequestParam Long id, @RequestParam Long amount) {
        return salesService.buyProduct(id, amount);
    }



    @GetMapping("/test")
    public String test() {
        return "sales";
    }
}
