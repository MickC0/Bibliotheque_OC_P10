package org.mickael.librarymscustomer.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.address_address_id_seq")
    @SequenceGenerator(name = "public.address_address_id_seq", sequenceName = "public.address_address_id_seq", allocationSize = 1)
    @Column(name = "address_id")
    private Integer id;

    @Column(name = "housenumber")
    private String housenumber;

    @Column(name = "street", length = 50, nullable = false)
    private String street;

    @Column(name = "postcode", length = 5, nullable = false)
    private String postcode;

    @Column(name = "city", length = 50, nullable = false)
    @Size(min = 3, max = 50)
    private String city;

    @Override
    public String toString() {
        return "Address{" +
                       "id=" + id +
                       ", housenumber='" + housenumber + '\'' +
                       ", street='" + street + '\'' +
                       ", postcode='" + postcode + '\'' +
                       ", city='" + city + '\'' +
                       '}';
    }
}
