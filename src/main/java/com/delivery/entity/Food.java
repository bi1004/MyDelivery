package com.delivery.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //음식 id,pk

    @Column(nullable = false)
    private String name; //음식 이름

    @Column(nullable = false)
    private int price;// 음식 가격

    @Column(nullable = false)
    private String category; // 음식 카테고리

    @Column(nullable = false)
    private String description; // 음식 설명

    @Column
    private String imageUrl; // 음식 사진 url

    @Column(nullable = false)
    private int quantity; // 음식 수량
}
