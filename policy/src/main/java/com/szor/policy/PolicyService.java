package com.szor.policy;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class PolicyService {

    public String getPolicy() {
        return "policy service";
    }
}
