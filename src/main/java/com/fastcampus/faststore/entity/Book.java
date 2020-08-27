package com.fastcampus.faststore.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
/**
 * 책 Entity
 * 책의 정보인 제목, 저자, 가격을 가진다
 */
public class Book extends BaseEntity {
    private String title;

    private String author;

    private Long price;
}
