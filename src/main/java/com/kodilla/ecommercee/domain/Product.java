package com.kodilla.ecommercee.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
@Table(name = "PRODUCTS")
public class Product {
    private Long id;
    private String name;
    private String description;
    private Long price;
    private List<Cart> carts;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "PRODUCT_ID", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @Column(name = "PRICE")
    public Long getPrice() {
        return price;
    }

    @ManyToMany(mappedBy = "listProduct")
    public List<Cart> getCarts() {
        return carts;
    }
}
