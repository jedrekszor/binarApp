package com.szor.warehouse;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class WarehouseService {

    public String getWarehouse() {
        return "warehouse service";
    }
}
