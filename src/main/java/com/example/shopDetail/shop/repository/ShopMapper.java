package com.example.shopDetail.shop.repository;

import com.example.shopDetail.shop.model.ShopDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopMapper {
    List<ShopDto> getShopById(ShopDto shopDto);
    List<ShopDto> getShopGrade();
}
