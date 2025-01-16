package com.fruit.pms.mapper;

import com.fruit.pms.dto.ItemDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemMapper {

    void insertItem(ItemDto itemDto);
    ItemDto getItemById(int id);
}
