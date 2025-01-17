package com.fruit.pms.mapper;

import com.fruit.pms.dto.ItemDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {

    void insertItem(ItemDto itemDto);
    ItemDto getItemById(int id);
    List<ItemDto> getItems();
    void updateItem(ItemDto itemDto);
    void deleteItem(int id);
}
