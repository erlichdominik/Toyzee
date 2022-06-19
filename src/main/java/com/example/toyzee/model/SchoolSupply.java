package com.example.toyzee.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class SchoolSupply {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;
    @NotNull
    @NotBlank
    private String schoolKind;

    @OneToOne()
    @JoinColumn(name = "product_id", nullable = false, updatable = false)
    @ToString.Exclude
    private Product product;
}
