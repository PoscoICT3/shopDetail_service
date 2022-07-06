package com.example.shopDetail.shop.service;

import com.example.shopDetail.shop.model.ShopDto;

import java.util.List;

public interface ShopService {
    List<ShopDto> findShopById(ShopDto shopDto);
}
