package org.mickael.librarymsbook.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.category_category_id_seq")
    @SequenceGenerator(name = "public.category_category_id_seq", sequenceName = "public.category_category_id_seq", allocationSize = 1)
    @Column(name = "category_id")
    private Integer id;

    @Column(name = "label")
    private String label;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "categories_of_books",
            joinColumns = { @JoinColumn(name = "category_id") },
            inverseJoinColumns = { @JoinColumn(name = "book_id") })
    private List<Book> books;
}
