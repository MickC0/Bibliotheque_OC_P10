package org.mickael.librarymsbook.model;

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
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.book_book_id_seq")
    @SequenceGenerator(name = "public.book_book_id_seq", sequenceName = "public.book_book_id_seq", allocationSize = 1)
    @Column(name = "book_id")
    private Integer id;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "summary")
    private String summary;

    @Column(name = "stock")
    private Integer stock;

    //@JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    private Author author;


    @ManyToOne(optional = false)
    @JoinColumn(name = "edition_id", referencedColumnName = "edition_id")
    private Edition edition;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cover_id", referencedColumnName = "cover_id")
    private Cover cover;

    //@JsonBackReference
    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    private List<Category> categories;






}
