package com.example.toyzee.model;

import lombok.*;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public abstract class Person {
    private String firstName;
    private String lastName;
}
