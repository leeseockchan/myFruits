package com.fruit.pms.dto;

import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor

public class PageDto {
    private int page;
    private int limit;
    private int totalPages;
    private int totalElements;
    private List<ItemDto> items;

//    @Builder 가 모든 생성자를 만들어 주는 역할을 한다.
//    public PageDto(List<ItemDto> items, int totalElements, int totalPages, int page, int limit) {
//        this.items = items;
//        this.totalElements = totalElements;
//        this.totalPages = totalPages;
//        this.page = page;
//        this.limit = limit;
//    }


}
