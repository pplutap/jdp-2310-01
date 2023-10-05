package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CART")
public class Cart {
    private Long id;
    private List<Product> listProduct;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @ManyToMany
    @JoinTable(
            name = "CART_PRODUCT",
            joinColumns = @JoinColumn(name = "CART_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID ")
    )
    public List<Product> getListProduct() {
        return listProduct;
    }
}
