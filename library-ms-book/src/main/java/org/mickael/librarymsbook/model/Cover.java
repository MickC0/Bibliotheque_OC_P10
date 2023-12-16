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
@Table(name = "cover")
public class Cover {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.cover_cover_id_seq")
    @SequenceGenerator(name = "public.cover_cover_id_seq", sequenceName = "public.cover_cover_id_seq", allocationSize = 1)
    @Column(name = "cover_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

}
