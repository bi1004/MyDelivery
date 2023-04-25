package com.delivery.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="food")
@Getter
@Setter
@ToString
public class Food {
    @Id
    @Column(name="food_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; //음식 id,pk

    @Column(nullable = false, length = 30)
    private String name; //음식 이름

    @Column(name="price", nullable = false)
    private int price;// 음식 가격

    @Column(nullable = false)
    private String category; // 음식 카테고리

    @Lob
    @Column(nullable = false)
    private String description; // 음식 설명

    @Column(nullable = false)
    private int quantity; // 음식 수량
}
