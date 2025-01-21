package com.fruit.pms.mapper;

import com.fruit.pms.dto.ItemDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemMapper {

    //int insertI/tem(ItemDto itemDto);// pk가 생성, 전달된 객체와 참조를 가지고 있어 정보 추가
    void insertItem(ItemDto itemDto);
    Optional<ItemDto> getItemById(int id); // pk 가 생성, int는 성공 또는 실패 반환
    List<ItemDto> getItems(@Param("limit") int limit, @Param("offset") int offset);
//    총 갯수
    int countTotal();
//    수정
    void updateItem(ItemDto itemDto); // 내용을 변경
//    삭제
    void deleteItem(int id);
}
