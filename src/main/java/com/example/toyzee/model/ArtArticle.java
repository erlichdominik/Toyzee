package com.example.toyzee.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ArtArticle extends SchoolSupply implements IToy{
    @NotNull
    @NotBlank
    private String usage;
    @OneToOne(mappedBy = "artArticle", orphanRemoval = true)
    @ToString.Exclude
    private AgeRestriction ageRestriction;

    @Override
    public Double getHeight() {
        return getProduct().getToy().getHeight();
    }

    @Override
    public Double getWidth() {
        return getProduct().getToy().getWidth();
    }

    @Override
    public String getMaterial() {
        return getProduct().getToy().getMaterial();
    }
}
