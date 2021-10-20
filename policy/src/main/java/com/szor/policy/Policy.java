package com.szor.policy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policy {
    private double bulkDiscountAmount;
    private double bulkDiscountPercentage;

    private double markupBottomAmount;
    private double markupBottomPercentage;

    private double markupUpperAmount;
    private double markupUpperPercentage;
}
