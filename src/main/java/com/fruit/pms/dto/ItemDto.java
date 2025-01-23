package com.fruit.pms.dto;


public class ItemDto {
    private Integer id;
    private String item;

    // Getter와 Setter 설정
    // lombok 일부러 사용 하지 않았음!!
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
}
