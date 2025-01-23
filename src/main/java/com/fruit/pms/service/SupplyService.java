package com.fruit.pms.service;

import com.fruit.pms.dto.PageDto;
import com.fruit.pms.dto.SupplyDto;
import com.fruit.pms.mapper.SupplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyService {

    @Autowired
    private SupplyMapper supplyMapper;
//  새로 만들기 - 생성
    public void createSupply(SupplyDto supplyDto) {
        supplyMapper.insertSupply(supplyDto);
    }
//  id 값 가져와서 id가 있는지 확인 함
    public SupplyDto getSupply(int id) {
        return supplyMapper.getSupplyById(id).orElseThrow(
                ()-> new IllegalStateException("데이터를 찾을 수 없습니다.")
        );
    }
//    페이지 목록 보기
    public PageDto<SupplyDto> getSupplyList(int page, int limit) {
        int offset = (page - 1) * limit;
        List<SupplyDto> supplyList = supplyMapper.getSupplyList(limit, offset);
        int totalElements = supplyMapper.countTotal();

        PageDto<SupplyDto> pageDto = new PageDto(page, limit, totalElements, supplyList);

        return pageDto;
    }

//     수정
    public void modifySupply(SupplyDto supplyDto) {supplyMapper.updateSupply(supplyDto);}
//    삭제
    public void deleteSupply(int id) {supplyMapper.deleteSupply(id);}
}
