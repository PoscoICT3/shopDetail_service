package com.example.shopDetail.shop.service;

import com.example.shopDetail.shop.model.ReviewDto;
import com.example.shopDetail.shop.model.ShopDto;
import com.example.shopDetail.shop.model.UserDto;
import com.example.shopDetail.shop.repository.ReviewListMapper;
import com.example.shopDetail.shop.repository.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService{
    @Autowired
    ShopMapper shopMapper;

    @Autowired
    ReviewListMapper reviewListMapper;

    @Override
    public HashMap<String, Object> findShopById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();


        URI uri1 = UriComponentsBuilder
                .fromUriString("http://localhost:8000")
                .path("/shoplist/rate")
                .encode()
                .build()
                .toUri();

        ResponseEntity<ShopDto[]> shopResult = restTemplate.getForEntity(uri1, ShopDto[].class);
        ShopDto[] shopArray = shopResult.getBody();
        ShopDto shopDto = shopArray[id - 1];

        URI uri2 = UriComponentsBuilder
                .fromUriString("http://localhost:8000")
                .path("/review/detail/" + id)
                .encode()
                .build()
                .toUri();

        ResponseEntity<ReviewDto[]> reviewResult = restTemplate.getForEntity(uri2, ReviewDto[].class);
        ReviewDto[] reviewArray = reviewResult.getBody();

        for (ReviewDto dto: reviewArray){
            URI uri3 = UriComponentsBuilder
                    .fromUriString("http://localhost:8000")
                    .path("/user/" + dto.getUserId())
                    .encode()
                    .build()
                    .toUri();

            ResponseEntity<UserDto> userResult = restTemplate.getForEntity(uri3, UserDto.class);
            UserDto userDto = userResult.getBody();

            dto.setUserName(userDto.getUserId());
        }
        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("shop", shopDto);
        map.put("review", reviewArray);

        return map;

//        System.out.println("amos(shopName): " + shopDto.getName());
//        System.out.println("amos(location): " + shopDto.getLocation());
//        System.out.println("amos(image): " + shopDto.getImage());
//        System.out.println("amos(grade): " + shopDto.getGrade());
//
//        for (ReviewDto dto: reviewArray){
//            System.out.println("review name: " + dto.getUserName());
//            System.out.println("review content: " + dto.getContent());
//            System.out.println("review photo: " + dto.getPhoto());
//            System.out.println("review rate: " + dto.getRate());
//        }
    }
}
