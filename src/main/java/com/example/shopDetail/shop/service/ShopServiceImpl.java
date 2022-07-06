package com.example.shopDetail.shop.service;

import com.example.shopDetail.shop.model.ShopDto;
import com.example.shopDetail.shop.repository.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService{
    @Autowired
    ShopMapper shopMapper;

    @Override
    public List<ShopDto> findShopById(ShopDto shopDto) {
        return shopMapper.getShopById(shopDto);
    }
}
