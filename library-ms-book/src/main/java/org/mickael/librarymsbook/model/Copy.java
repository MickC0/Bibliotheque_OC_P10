package org.mickael.librarymsbook.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "copy")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Copy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.copy_copy_id_seq")
    @SequenceGenerator(name = "public.copy_copy_id_seq", sequenceName = "public.copy_copy_id_seq", allocationSize = 1)
    @Column(name = "copy_id")
    private Integer id;

    @Column(name = "available", nullable = false)
    private boolean available;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    private Book book;


}
