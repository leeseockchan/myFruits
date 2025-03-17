package com.fruit.pms.dto;


public class ItemDto {
    private Integer id;
    private String item;
    private String imageUrl;

    // Getter와 Setter 설정
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

    public String getImageUrl() {return imageUrl;}
    public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}
}
