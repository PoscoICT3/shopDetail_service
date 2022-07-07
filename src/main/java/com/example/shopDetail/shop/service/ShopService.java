package com.example.shopDetail.shop.service;

import com.example.shopDetail.shop.model.ShopDto;

import java.util.HashMap;
import java.util.List;

public interface ShopService {
    HashMap<String, Object> findShopById(Integer id);
}
