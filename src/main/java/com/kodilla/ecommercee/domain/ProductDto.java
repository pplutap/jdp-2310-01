package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private Long price;
    private Group group;

}
