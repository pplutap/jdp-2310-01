package com.kodilla.ecommercee.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    private Group group;
    private Order order;

    public Product(String name, String description, Long price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

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

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    public Group getGroup() {
        return group;
    }

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    public Order getOrder() {
        return order;
    }

    public Product(String name, String description, Long price, Group group) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.group = group;
    }


}
