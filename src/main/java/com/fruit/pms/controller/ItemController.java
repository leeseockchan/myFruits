package com.fruit.pms.controller;

import com.fruit.pms.dto.ItemDto;
import com.fruit.pms.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/items")
public class ItemController {

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
        itemService.createItem(itemDto);
    }

    @GetMapping("/{id}")
    public String getItem(@PathVariable("id") int id, Model model) {
        try {
            ItemDto itemDto = itemService.getItem(id);
            model.addAttribute("item", itemDto);
        } catch (IllegalStateException e) {
            model.addAttribute("message", e.getMessage());
            return "common/error/404";
        }
        return "shop/detail";
    }

    @GetMapping
    public String getItems(@RequestParam(name = "page", defaultValue = "1") int page,
                           @RequestParam(name = "limit", defaultValue = "10") int limit, Model model){
        List<ItemDto> items = itemService.getItems(page, limit);
        model.addAttribute("items", items);

        return "shop/list";
    }


    // modify나 edit 를 사용한다.
    @GetMapping("/{id}/modify")
    public String getItem2(@PathVariable("id") int id, Model model) {
        try {
            ItemDto itemDto = itemService.getItem(id);
            model.addAttribute("item", itemDto);
        } catch (IllegalStateException e) {
            model.addAttribute("message", e.getMessage());
            return "common/error/404";
        }
        return "shop/modify";
    }

    @PostMapping("/{id}/modify")
    @ResponseBody
    public void modifyItem(@RequestBody ItemDto itemDto) {
        System.out.println(itemDto.getItem());
        itemService.modifyItem(itemDto);
    }

    @GetMapping("/{id}/remove")
    public String removeItem(@PathVariable("id") int id) {
        itemService.removeItem(id);
        return "redirect:/items";
    }

    // HTML 파일로 할 경우 ( thymeleaf )
    // 생성 페이지 GET /items/create
    // 생성 POST /items
    // 상세보기 GET /items/{id}
    // 수정 POST /items/{id}
    // 수정페이지 GET/items/{id}/modify
    // 삭제 Get /items/{id}
    
    // JSON 파일로 할 경우
    // 생성 페이지 GET /items/create
    // 생성 POST /items
    // 상세보기 GET /items/{id}
    // 수정 PUT /items/{id}
    // 삭제 DELETE /items/{id}
}
