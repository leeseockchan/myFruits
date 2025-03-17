package com.fruit.pms.controller;

import com.fruit.pms.dto.ItemDto;
import com.fruit.pms.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/create")
    public String create() {
        return "shop/create-item";
    }

    @PostMapping("/create")
    public String createItem(@ModelAttribute ItemDto itemDto,
                           @RequestParam("itemImage") MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                // 새 이미지 저장
                String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                Path imagePath = Paths.get("E:/images/", filename);
                Files.createDirectories(imagePath.getParent()); // 폴더 없으면 생성
                file.transferTo(imagePath.toFile());
                // DB에 저장할 이미지 경로 업데이트
                itemDto.setImageUrl("/images/" + filename); // DB에 저장될 경로
            }

            // DB에 상품 정보 저장
            itemService.createItem(itemDto);
            return "redirect:/items"; // 생성 후 아이템 목록 페이지로 리디렉션

        } catch (IOException e) {
            e.printStackTrace();
            return "파일 업로드 실패";
        }
    }

    @GetMapping("/{id}")
    public String getItem(@PathVariable("id") int id, Model model) {
        try {
            ItemDto itemDto = itemService.getItem(id);
            if (itemDto.getImageUrl() == null) {
                itemDto.setImageUrl("");
            }
            model.addAttribute("item", itemDto);
        } catch (IllegalStateException e) {
            model.addAttribute("message", e.getMessage());
            return "common/error/404";
        }
        return "shop/detail";
    }

    @GetMapping
    public String getItems(Model model) {
        List<ItemDto> items = itemService.getItems();
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

    //
    @PostMapping("/{id}/modify")
    @ResponseBody
    public String updateItem(@ModelAttribute ItemDto itemDto,
                             @RequestParam("itemImage") MultipartFile file) {
        try {
            // 기존 이미지 삭제
            if (itemDto.getImageUrl() != null && !itemDto.getImageUrl().isEmpty()) {
                // DB에서 저장된 이미지 경로를 잘라서 실제 파일 경로로 변환
                String imagePath = itemDto.getImageUrl().replace("/images/", "");
                Path oldImagePath = Paths.get("E:/images", imagePath);
                Files.deleteIfExists(oldImagePath);  // 기존 파일 삭제
            }

            // 새 이미지 저장
            if (!file.isEmpty()) {
                String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                Path imagePath = Paths.get("E:/images", filename);
                Files.createDirectories(imagePath.getParent()); // 폴더 없으면 생성
                file.transferTo(imagePath.toFile());

                // DB에 저장할 이미지 경로 업데이트 (상대 경로)
                itemDto.setImageUrl("/images/" + filename);
            }

            // DB 업데이트
            itemService.modifyItem(itemDto);  // 이미지 경로와 수정된 아이템을 DB에 반영
        } catch (IOException e) {
            e.printStackTrace();
            return "파일 업로드 실패";
        }
        return "redirect:/items/" + itemDto.getId();
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
