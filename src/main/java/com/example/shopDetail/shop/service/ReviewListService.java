package com.example.shopDetail.shop.service;

import com.example.shopDetail.shop.model.ReviewDto;

import java.util.List;

public interface ReviewListService {
    List<ReviewDto> findReviewByShopId(ReviewDto reviewDto);
}
