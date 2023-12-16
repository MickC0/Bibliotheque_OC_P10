package org.mickael.librarymscustomer.service.contract;



import org.mickael.librarymscustomer.exception.CustomerAlreadyExistException;
import org.mickael.librarymscustomer.exception.CustomerNotFoundException;
import org.mickael.librarymscustomer.model.Customer;

import java.util.List;

public interface CustomerServiceContract {


    List<Customer> findAll() throws CustomerNotFoundException;

    Customer findById(Integer id) throws CustomerNotFoundException;

    Customer save(Customer customer) throws CustomerAlreadyExistException;

    Customer update(Customer customer) throws CustomerNotFoundException;

    Customer findByLastName(String lastName) throws CustomerNotFoundException;

    Customer findByEmail(String email) throws CustomerNotFoundException;

    List<Customer> findCustomersByAddressId(Integer id) throws CustomerNotFoundException;

    List<Customer> findCustomersByEmail(String email);

    void deleteById(Integer id);

}
