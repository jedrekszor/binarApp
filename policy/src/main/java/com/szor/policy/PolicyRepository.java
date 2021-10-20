package com.szor.policy;

import org.springframework.stereotype.Component;

@Component
public class PolicyRepository {
    private final Policy policy = new Policy(
            3,
            0.5,
            4,
            0.3,
            15,
            0.1
    );

    public Policy getPolicy() {
        return policy;
    }
}
