package com.example.toyzee.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Toy implements IToy{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Positive
    @NotNull
    private Double height;
    @Positive
    @NotNull
    private Double width;
    @NotNull
    @NotBlank
    private String material;

    @OneToOne(mappedBy = "toy", orphanRemoval = true, cascade = CascadeType.ALL)
    @ToString.Exclude
    private AgeRestriction ageRestriction;

    @OneToOne()
    @JoinColumn(name = "product_id", nullable = false, updatable = false)
    @ToString.Exclude
    private Product product;

}
