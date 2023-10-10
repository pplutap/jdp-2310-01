package com.kodilla.ecommercee.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "USER_ID", unique = true)
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "STATUS")
    private int status;

    @Column(name = "USER_KEY")
    private Long userKey;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    public Order order;

    public User(String username, int status, Long userKey) {
        this.username = username;
        this.status = status;
        this.userKey = userKey;
    }

}
