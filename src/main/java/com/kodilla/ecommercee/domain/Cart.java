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

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    public List<Product> getListProduct() {
        return listProduct;
    }
}
