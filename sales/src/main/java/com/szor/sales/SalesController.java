package com.szor.sales;

import com.szor.policy.PolicyService;
import com.szor.warehouse.WarehouseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
@AllArgsConstructor
public class SalesController {

    private final WarehouseService warehouseService;
    private final PolicyService policyService;

    @GetMapping("/test")
    public String test() {
        return "sales";
    }

    @GetMapping("/testws")
    public String testws() {
        return warehouseService.getWarehouse();
    }

    @GetMapping("/testps")
    public String testps() {
        return policyService.getPolicy();
    }
}
