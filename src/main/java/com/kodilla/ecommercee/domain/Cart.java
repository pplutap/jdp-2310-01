package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CART")
public class Cart {
    private Long id;
    private List<Product> listProduct;
    private Order order;

    public Cart(Long id, List<Product> listProduct) {
        this.id = id;
        this.listProduct = listProduct;
    }
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @OneToMany(mappedBy = "cart")
    public List<Product> getListProduct() {
        return listProduct;
    }

    @OneToOne
    public Order getOrder() {
        return order;
    }

    public Cart(List<Product> listProduct){
        this.listProduct = listProduct;
    }

    public void addProductToCart(Product product) {
        if(product != null) {
            product.setCart(this);
            listProduct.add(product);
        }
    }
}

