package org.mickael.librarymscustomer.service.impl;


import org.mickael.librarymscustomer.exception.CustomerAlreadyExistException;
import org.mickael.librarymscustomer.exception.CustomerNotFoundException;
import org.mickael.librarymscustomer.model.Customer;
import org.mickael.librarymscustomer.model.enumeration.Role;
import org.mickael.librarymscustomer.repository.CustomerRepository;
import org.mickael.librarymscustomer.service.contract.CustomerServiceContract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerServiceContract {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceContract.class);
    private final org.mickael.librarymscustomer.repository.CustomerRepository CustomerRepository;

    //private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public CustomerServiceImpl(CustomerRepository CustomerRepository /*, BCryptPasswordEncoder passwordEncoder*/) {
        this.CustomerRepository = CustomerRepository;
        //this.passwordEncoder = passwordEncoder;
    }


    @Override
    public List<Customer> findAll() throws CustomerNotFoundException {
        List<Customer> customers = CustomerRepository.findAll();
        logger.info("Liste de compte vide :" + customers.isEmpty());
        if (customers.isEmpty()) {
            throw new CustomerNotFoundException("No Customer found");
        }
        logger.info("liste des comptes : " + customers.stream().toString());
        return customers;
    }

    @Override
    public Customer findById(Integer id) throws CustomerNotFoundException {
        Optional<Customer> customer = CustomerRepository.findById(id);
        if (!customer.isPresent()){
            throw new CustomerNotFoundException("Customer not found in repository");
        }
        return customer.get();
    }

    @Override
    public Customer save(Customer Customer) throws CustomerAlreadyExistException {
        Customer existingCustomer = CustomerRepository.findByEmail(Customer.getEmail());
        if (existingCustomer != null){
            throw new CustomerAlreadyExistException("Customer already exist");
        }

        Customer savedCustomer = new Customer();
        logger.info("Roles value : " + Role.CLIENT.getAbbreviation());
        savedCustomer.setRegistrationDate(LocalDateTime.now());
        savedCustomer.setUpdateDate(LocalDateTime.now());
        CustomerRepository.save(savedCustomer);
        return savedCustomer;
    }

    @Override
    public Customer update(Customer Customer) throws CustomerNotFoundException {
        Optional<Customer> existingCustomer = CustomerRepository.findById(Customer.getId());
        if (!existingCustomer.isPresent()){
            throw new CustomerNotFoundException("Customer not found in repository");
        }
        Customer UpdateCustomer = new Customer();
        UpdateCustomer.setAddress(existingCustomer.get().getAddress());
        UpdateCustomer.setUpdateDate(LocalDateTime.now());
        CustomerRepository.save(UpdateCustomer);
        return UpdateCustomer;
    }

    @Override
    public Customer findByLastName(String lastName) throws CustomerNotFoundException {
        Customer Customer = CustomerRepository.findByLastName(lastName);
        if (Customer == null){
            throw new CustomerNotFoundException("Customer not found in repository");
        }
        return Customer;
    }

    @Override
    public Customer findByEmail(String email) throws CustomerNotFoundException {
        Customer customer = CustomerRepository.findByEmail(email);
        if (customer == null){
            throw new CustomerNotFoundException("Customer not found in repository");
        }
        return customer;
    }

    @Override
    public List<Customer> findCustomersByAddressId(Integer id) throws CustomerNotFoundException {
        List<Customer> Customers = CustomerRepository.findCustomersByAddressId(id);
        if (Customers.isEmpty()){
            throw new CustomerNotFoundException("No Customer found for this address");
        }
        return Customers;
    }

    @Override
    public void deleteById(Integer id) {
        CustomerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findCustomersByEmail(String email) {
        return CustomerRepository.findByEmailLike("%"+email+"%");
    }

}
