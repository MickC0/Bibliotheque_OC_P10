package org.mickael.librarymsbook.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "edition")
public class Edition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.edition_edition_id_seq")
    @SequenceGenerator(name = "public.edition_edition_id_seq", sequenceName = "public.edition_edition_id_seq", allocationSize = 1)
    @Column(name = "edition_id")
    private Integer id;

    @Column(name = "label", nullable = false)
    private String label;

}
