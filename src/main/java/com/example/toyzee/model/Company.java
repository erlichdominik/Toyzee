package com.example.toyzee.model;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Company {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;
    private String name;
    private String location;

    @ManyToMany
    @JoinTable(name = "company_products",
            joinColumns = @JoinColumn(name = "company_null"),
            inverseJoinColumns = @JoinColumn(name = "products_null"))
    @ToString.Exclude
    @Builder.Default
    private Set<Product> products = new LinkedHashSet<>();

}
