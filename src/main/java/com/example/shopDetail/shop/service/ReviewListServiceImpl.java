package com.example.shopDetail.shop.service;

import com.example.shopDetail.shop.model.ReviewDto;
import com.example.shopDetail.shop.repository.ReviewListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewListServiceImpl implements ReviewListService {
    @Autowired
    ReviewListMapper reviewListMapper;

    @Override
    public List<ReviewDto> findReviewByShopId(ReviewDto reviewDto) {
        return reviewListMapper.getReviewByShopId(reviewDto);
    }
}
