package com.example.toyzee.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) private Long id;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @Min(1)
    @Max(50)
    private Integer percentageOfDiscount;

    @ManyToMany(mappedBy = "discounts")
    @ToString.Exclude
    @Builder.Default
    private Set<Customer> customers = new LinkedHashSet<>();

    @OneToOne(mappedBy = "discount", orphanRemoval = true)
    @ToString.Exclude
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Discount discount = (Discount) o;
        return id != null && Objects.equals(id, discount.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
