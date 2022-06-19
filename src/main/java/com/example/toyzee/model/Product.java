package com.example.toyzee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @Positive
    private Double price;
    @NotNull
    @PositiveOrZero
    private Integer quantity;
    @NotNull
    private LocalDateTime publishedDate;

    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "discounts_id")
    @ToString.Exclude
    private Discount discount;

    @OneToOne(mappedBy = "product", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @JsonIgnore
    private SchoolSupply schoolSupply;

    @OneToOne(mappedBy = "product", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @JsonIgnore
    private Toy toy;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    private Book book;

    @ManyToMany(mappedBy = "products")
    @ToString.Exclude
    @Builder.Default
    private Set<Company> companies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    @Builder.Default
    private Set<OrderProductDetail> orderProductDetails = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return id != null && Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
