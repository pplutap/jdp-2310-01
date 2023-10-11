package com.kodilla.ecommercee.domain;

import lombok.*;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
@Table(name = "GROUPSS")
public class Group {
    private Long id;
    private String name;
    private List<Product> productsList;

    public Group(String name) {
        this.name = name;
    }

    public Group(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "GROUP_ID",
            unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @OneToMany(targetEntity = Product.class,
            mappedBy = "group",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY)
    public List<Product> getProductsList() {
        return productsList;
    }
}