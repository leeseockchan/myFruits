package com.fruit.pms.controller;

import com.fruit.pms.dto.ItemDto;
import com.fruit.pms.mapper.ItemMapper;
import com.fruit.pms.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ItemService itemService;
    @GetMapping("/create")
    public String create() {
        return "shop/create-item";
    }

    @PostMapping
    @ResponseBody
    public void createItem(@RequestBody ItemDto itemDto) {
        System.out.println(itemDto.getItem());
        itemMapper.insertItem(itemDto);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ItemDto getItem(@PathVariable("id") int id) {
        return itemService.getItem(id);
    }
}
