package com.example.toyzee;

import com.example.toyzee.model.*;
import com.example.toyzee.repository.*;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class ToyzeeApplication {
    private final AuthorRepository authorRepository;
    private final PersonRepository personRepository;
    private final CustomerRepository customerRepository;
    private final BookRepository bookRepository;
    private final ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(ToyzeeApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            Faker faker = new Faker(new Random(11));
            Faker faker1 = new Faker(new Random(20));
            Faker faker2 = new Faker(new Random(15312));
            Faker faker3 = new Faker(new Random(3213));
            for (int i = 0; i < 5 ; i++) {
                Person person1 = new Person(faker.name().firstName(), faker.name().lastName());
                Person person2 = new Person(faker1.name().firstName(), faker1.name().lastName());
                Person person3 = new Person(faker2.name().firstName(), faker2.name().lastName());
                Person person4 = new Person(faker3.name().firstName(), faker3.name().lastName());
                Customer customer1 = new Customer(faker.bothify("????##@gmail.com"),
                        faker.bothify("?#?#?#?#?###?#"),
                        "20",
                        person1);


                personRepository.save(person1);
                personRepository.save(person2);
                personRepository.save(person3);
                customerRepository.save(customer1);

                person1.setCustomer(customer1);
                personRepository.save(person1);

                AgeRestriction ageRestriction = AgeRestriction.builder()
                        .min(faker.number().numberBetween(5, 12))
                        .max(faker.number().numberBetween(24, 99))
                        .build();

                AgeRestriction ageRestriction2 = AgeRestriction.builder()
                        .min(faker.number().numberBetween(5, 12))
                        .max(faker.number().numberBetween(24, 99))
                        .build();




                Product product = Product.builder()
                        .name(faker.book().title())
                        .price(Double.valueOf(faker.commerce().price(10, 30)))
                        .publishedDate(LocalDateTime.now())
                        .quantity(20)
                        .build();

                Product product2 = Product.builder()
                        .name(faker.book().title())
                        .price(Double.valueOf(faker.commerce().price(10, 30)))
                        .publishedDate(LocalDateTime.now())
                        .quantity(20)
                        .build();

                Book book = new Book(faker.book().genre(), product);
                Book book2 = new Book(faker.book().genre(), product2);

                book.setAgeRestriction(ageRestriction);
                book2.setAgeRestriction(ageRestriction2);
                ageRestriction.setBook(book);
                ageRestriction2.setBook(book2);

                product.setBook(book);
                product2.setBook(book2);

                productRepository.saveAll(List.of(product, product2));

                Author author = new Author(new HashSet<>(Set.of(faker.book().publisher(), faker2.book().publisher())), person2);
                Author author1 = new Author(new HashSet<>(Set.of(faker1.book().publisher(), faker.book().publisher())), person3);
                Author author2 = new Author(new HashSet<>(Set.of(faker2.book().publisher())), person4);

//                author.addBook(book);
                author.getBooks().add(book);
                author.getBooks().add(book2);
                author1.getBooks().add(book);
                author2.getBooks().add(book2);

                person4.setAuthor(author2);
                person2.setAuthor(author);
                person3.setAuthor(author1);

                personRepository.save(person2);
                personRepository.save(person3);
                personRepository.save(person4);

//                authorRepository.save(author);
            }

        };
    }
}
