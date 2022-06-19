package com.example.toyzee.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotBlank
    private String numberOfOrders;
    @Email
    @NotNull
    private String email;
    @NotNull
    private String password;

    public Customer(String email, String password, String numberOfOrders, Person person) {
        this.email = email;
        this.password = password;
        this.numberOfOrders = numberOfOrders;
        this.person = person;
//        person.setCustomer(this);
    }

    @OneToOne()
    @JoinColumn(name = "person_id", nullable = false, updatable = false)
    @ToString.Exclude
    private Person person;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "customer_discountses",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "discountses_id"))
    @ToString.Exclude
    @Builder.Default
    private Set<Discount> discounts = new LinkedHashSet<>();

    @OneToOne
    @JoinColumn(name = "customerOrder")
    @ToString.Exclude
    private CustomerOrder customerOrder;
}
