package com.example.shopDetail.shop.model;

import lombok.Data;

@Data
public class ReviewDto {
    private Integer id;
    private Integer userId;
    private String userName;
    private Integer shopId;
    private Integer rate;
    private String content;
    private String photo;
}
