package com.example.toyzee.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotBlank
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "age_restriction_id")
    @ToString.Exclude
    private AgeRestriction ageRestriction;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false, updatable = false)
    @ToString.Exclude
    private Product product;

    @ManyToMany(mappedBy = "books")
    @ToString.Exclude
    @Builder.Default
//    @JsonIgnore
    private Set<Author> authors = new HashSet<>();

    public Book(String description, Product product) {
        this.description = description;
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && description.equals(book.description) && Objects.equals(ageRestriction, book.ageRestriction) && Objects.equals(product, book.product) && Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, ageRestriction, product, authors);
    }


}
