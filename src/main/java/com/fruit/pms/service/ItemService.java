package com.fruit.pms.service;

import com.fruit.pms.dto.ItemDto;
import com.fruit.pms.dto.PageDto;
import com.fruit.pms.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemMapper itemMapper;

    public void createItem(ItemDto itemDto) {
        itemMapper.insertItem(itemDto);
    }

    public ItemDto getItem(int id) {
//         NullException 처리
//        ItemDto item = itemMapper.getItemById(id).orElseThrow(
//                () -> new IllegalStateException("파일을 찾을 수 없습니다.")
//        );
        return itemMapper.getItemById(id).orElseThrow(
                () -> new IllegalStateException("파일을 찾을 수 없습니다.")
        );
    }

    public PageDto<ItemDto> getItems(int page, int limit) {
        int offset = (page - 1) * limit; // 목록
//      갯수가 size 인 item 목록
        List<ItemDto> items = itemMapper.getItems(limit, offset);
        // 총 갯수
        int totalElements = itemMapper.countTotal();
        // 총 페이지
        // Math.ceil - 올림
        // 13 /5 = 2.xxxx => 3 => (int) 3
//        int totalPages = (int) Math.ceil((double)totalElements / limit);

        PageDto<ItemDto> pageDto = new PageDto(page, limit, totalElements, items);

        return pageDto;
    }


    public void modifyItem(ItemDto itemDto) {
        itemMapper.updateItem(itemDto);
    }

    public void removeItem(int id) {
        itemMapper.deleteItem(id);
    }

    // 함수
    // 접근제어자 리턴 타입 메소드이름(){}


}
