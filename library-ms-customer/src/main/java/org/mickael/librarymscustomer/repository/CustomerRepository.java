package org.mickael.librarymscustomer.repository;


import org.mickael.librarymscustomer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


    Customer findByLastName(String lastName);

    Customer findByEmail(String email);
    List<Customer> findByEmailLike(String email);

    void deleteById(Integer id);

    @Query(value = "SELECT customer FROM Customer customer WHERE customer.address.id = :id")
    List<Customer> findCustomersByAddressId (@Param("id") Integer id);



}
