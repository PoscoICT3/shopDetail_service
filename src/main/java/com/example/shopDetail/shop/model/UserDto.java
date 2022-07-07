package com.example.shopDetail.shop.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserDto {
    private Integer id;
    private String userId;
}
