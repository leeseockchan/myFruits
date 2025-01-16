package com.fruit.pms.service;

import com.fruit.pms.dto.ItemDto;
import com.fruit.pms.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemMapper itemMapper;


    public ItemDto getItem(int id) {
        return itemMapper.getItemById(id);
    }

    // 함수
    // 접근제어자 리턴 타입 메소드이름(){}


}
