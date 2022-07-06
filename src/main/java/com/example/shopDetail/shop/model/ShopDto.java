package com.example.shopDetail.shop.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ShopDto {
    private Integer id;
    private String name;
    private String location;
    private String image;
    private double grade;
}
