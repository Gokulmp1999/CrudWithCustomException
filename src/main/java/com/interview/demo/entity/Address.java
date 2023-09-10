package com.interview.demo.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@Component
public class Address {
    private String pinCode="673517";
    private String addressLines;
    private String Country="INDIA";
}
