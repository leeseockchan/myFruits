package com.fruit.pms.dto;

import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class PageDto<T> {
    private int page;
    private int limit;
    private int totalPages;
    private int totalElements;
    private List<T> content;

    public PageDto(int page, int limit, int totalElements, List<T> content) {
        this.page = page;
        this.limit = limit;
        this.totalElements = totalElements;
        this.totalPages = (int) Math.ceil((double) totalElements / limit);
        this.content = content;
    }

//    @Builder 가 모든 생성자를 만들어 주는 역할을 한다.
//    public PageDto(List<ItemDto> items, int totalElements, int totalPages, int page, int limit) {
//        this.items = items;
//        this.totalElements = totalElements;
//        this.totalPages = totalPages;
//        this.page = page;
//        this.limit = limit;
//    }


}
