package com.szor.policy;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/policy")
@AllArgsConstructor
public class PolicyController {

    private final PolicyRepository policyRepository;

    @GetMapping("/getPolicy")
    public Policy getPolicy() {
        return policyRepository.getPolicy();
    }

    //update policy
}
