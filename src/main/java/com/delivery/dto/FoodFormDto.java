package com.delivery.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter @Setter
public class FoodFormDto {

    private int id;

    @NotBlank(message = "음식명은 필수 입력 입니다.")
    private String name;

    @NotBlank(message = "음식 가격은 필수 입력 입니다.")
    private int price;

    @NotBlank(message = "카테고리는 필수 입력 입니다.")
    private String category;

    @NotBlank(message = "음식 설명은 필수 입력 입니다.")
    private String description;

    @NotBlank(message = "수량은 필수 입력 입니다.")
    private int quantity;

}
