package com.fruit.pms.controller;

import com.fruit.pms.dto.ItemDto;
import com.fruit.pms.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemClass {

    @Autowired
    private ItemMapper itemMapper;

    @GetMapping("/create")
    public String create(){
        return "shop/create-Item";
    }

    @PostMapping
    public void createItem(@RequestBody ItemDto itemDto){
        System.out.println(itemDto.getItem());
        itemMapper.insertItem(itemDto);
    }
}
