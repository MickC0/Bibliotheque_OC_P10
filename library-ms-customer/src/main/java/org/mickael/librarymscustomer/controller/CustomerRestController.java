package org.mickael.librarymscustomer.controller;


import io.swagger.annotations.ApiOperation;
import org.mickael.librarymscustomer.exception.CustomerAlreadyExistException;
import org.mickael.librarymscustomer.exception.CustomerNotFoundException;
import org.mickael.librarymscustomer.model.Customer;
import org.mickael.librarymscustomer.service.contract.CustomerServiceContract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
//@PreAuthorize("isAuthenticated()")
public class CustomerRestController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerRestController.class);
    private final CustomerServiceContract customerServiceContract;



    @Autowired
    public CustomerRestController(CustomerServiceContract customerServiceContract) {
        this.customerServiceContract = customerServiceContract;
    }

    @ApiOperation(value = "Récupère l'ensemble des comptes présents et les stocke dans une liste")
    @GetMapping
    //@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    public List<Customer> getCustomers() {
        try {
            return customerServiceContract.findAll();
        } catch (CustomerNotFoundException ex){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "No Customers found",ex);
        }
    }

    @ApiOperation(value = "Récupère un compte à partir de son ID à condition que celui-ci existe")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    //@PreAuthorize("hasAuthority('READ')")
    //@PostAuthorize("(returnObject.email == authentication.name) or hasAnyRole('ADMIN', 'EMPLOYEE')")
    public Customer retrieveCustomer(@Param("id") @PathVariable Integer id){

        try {
            return customerServiceContract.findById(id);
        } catch (CustomerNotFoundException ex){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found",ex);
        }
    }

    @ApiOperation(value = "Créé un nouveau compte avec vérification si celui-ci est existant.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    public ResponseEntity<Void> createNewCustomer(@Valid @RequestBody Customer newCustomer){
        if (newCustomer == null){
            return ResponseEntity.noContent().build();
        }
        try {
            Customer customerToSave = customerServiceContract.save(newCustomer);
            URI location = ServletUriComponentsBuilder
                                   .fromCurrentRequest()
                                   .path("/{id}")
                                   .buildAndExpand(customerToSave.getId()).toUri();
            return ResponseEntity.created(location).build();
        } catch (CustomerAlreadyExistException ex){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Customer already exist", ex);
        }
    }

    @ApiOperation(value = "Mise à jour du compte sélectionné par son ID")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    //@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id,@Valid @RequestBody Customer customer,
                                                 @RequestHeader("Authorization") String token){
        try {
            Customer updateCustomer = customerServiceContract.update(customer);
            ResponseEntity responseEntity = new ResponseEntity<Customer>(updateCustomer, HttpStatus.OK);
            responseEntity.getHeaders().add("Authorization", token);
            return responseEntity;
        } catch (CustomerNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide correct Customer Id", ex);
        }
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAuthority('DELETE')")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id){
        customerServiceContract.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
