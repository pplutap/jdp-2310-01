package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Table(name = "ORDERS")
public class Order {
    private Long id;
    private Long cartId;
    private Long userId;
    private LocalDate created;
    private BigDecimal cost;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "CART_ID")
    public Long getCartId() {
        return cartId;
    }
    @Column(name = "USER_ID")
    public Long getUserId() {
        return userId;
    }

    @Column(name = "CREATED")
    public LocalDate getCreated() {
        return created;
    }

    @Column(name = "COST")
    public BigDecimal getCost() {
        return cost;
    }
}
