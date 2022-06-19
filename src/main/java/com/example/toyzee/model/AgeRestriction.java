package com.example.toyzee.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Objects;

import static javax.persistence.CascadeType.ALL;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgeRestriction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Positive
    @NotNull
    private Integer min;
    @Positive
    @NotNull
    private Integer max;

    @OneToOne(mappedBy = "ageRestriction", cascade = ALL)
    @ToString.Exclude
    private Book book;

    @OneToOne()
    @JoinColumn(name = "toy_id")
    @ToString.Exclude
    private Toy toy;

    @OneToOne()
    @JoinColumn(name = "art_article_id")
    @ToString.Exclude
    private ArtArticle artArticle;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgeRestriction that = (AgeRestriction) o;
        return Objects.equals(id, that.id) && Objects.equals(min, that.min) && Objects.equals(max, that.max);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, min, max);
    }
}
