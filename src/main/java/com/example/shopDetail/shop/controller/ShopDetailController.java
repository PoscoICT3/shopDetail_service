package com.example.shopDetail.shop.controller;


import com.example.shopDetail.shop.model.ReviewDto;
import com.example.shopDetail.shop.model.ShopDto;
import com.example.shopDetail.shop.service.ReviewListServiceImpl;
import com.example.shopDetail.shop.service.ShopServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("shopdetail")
public class ShopDetailController {

    @Autowired
    ShopServiceImpl shopService;

    @Autowired
    ReviewListServiceImpl reviewListService;

    @PostMapping("detail/{id}")
    public HashMap<String, Object> getShopPostById(@PathVariable String id){
        HashMap<String, Object> map = new HashMap<String, Object>();

        ShopDto shopDto = new ShopDto();
        shopDto.setId(Integer.valueOf(id));

        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setShopId(Integer.valueOf(id));

        List<ShopDto> shopDetail = shopService.findShopById(shopDto);
        List<ReviewDto> reviewList = reviewListService.findReviewByShopId(reviewDto);

        map.put("shop", shopDetail);
        map.put("review", reviewList);
        System.out.println("this is map........"+map);

        return map;
    }

    @GetMapping("review/{id}")
    public List<ReviewDto> getReviewByShopId(@PathVariable String id){
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setShopId(Integer.valueOf(id));
        return reviewListService.findReviewByShopId(reviewDto);
    }
}
