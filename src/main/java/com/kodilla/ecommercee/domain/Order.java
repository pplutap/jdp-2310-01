package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Table(name = "ORDERS")
public class Order {
    private Long id;
    private String name;
    private LocalDate created;
    private BigDecimal cost;
    private List<Product> productsList;
    private User user;


    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "CREATED")
    public LocalDate getCreated() {
        return created;
    }

    @Column(name = "COST")
    public BigDecimal getCost() {
        return cost;
    }

    @OneToMany(targetEntity = Product.class,
            mappedBy = "order",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY)
    public List<Product> getProductsList() {
        return productsList;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public Order(String name, LocalDate created){
        this.name = name;
        this.created = created;
    }
}
