package com.fruit.pms.mapper;

import com.fruit.pms.dto.SupplyDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SupplyMapper {
    void insertSupply(SupplyDto supplyDto);// pk 가 생성,
    Optional<SupplyDto> getSupplyById(int id);
    List<SupplyDto> getSupplyList(@Param("limit") int limit, @Param("offset") int offset);
    int countTotal();
    void updateSupply(SupplyDto supplyDto); // 내용을 변경
    void deleteSupply(int id);
}
