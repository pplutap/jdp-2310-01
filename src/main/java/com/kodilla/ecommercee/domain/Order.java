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
    private Cart cartId;
    private User userId;
    private LocalDate created;
    private BigDecimal cost;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CART_ID")
    public Cart getCartId() {
        return cartId;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    public User getUserId() {
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
