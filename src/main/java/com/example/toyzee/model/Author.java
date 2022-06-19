package com.example.toyzee.model;


import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "publishing_houses", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "publishingHouses")
    private Set<String> publishingHouses = new HashSet<>();

    @OneToOne()
    @JoinColumn(name = "person_id", nullable = false, updatable = false)
    private Person person;


    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
    @ToString.Exclude
    @Builder.Default
//    @JsonBackReference
//    @JsonIgnore
    private Set<Book> books = new HashSet<>();

    public Author(Set<String> publishingHouses, Person person) {
        this.publishingHouses = publishingHouses;
        this.person = person;
        this.books = new HashSet<>();
    }

//    public void addBook(Book book) {
//        this.books.add(book);
//        book.getAuthors().add(this);
//    }

    public void setBooks(Set<Book> books) {
      if (this.books == null) {
          this.books = books;
      } else {
          this.books.addAll(books);
      }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Author author = (Author) o;
        return id != null && Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
