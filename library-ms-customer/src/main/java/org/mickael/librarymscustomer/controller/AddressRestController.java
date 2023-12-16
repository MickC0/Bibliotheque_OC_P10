package org.mickael.librarymscustomer.controller;


import org.mickael.librarymscustomer.exception.AddressNotFoundException;
import org.mickael.librarymscustomer.model.Address;
import org.mickael.librarymscustomer.service.contract.AddressServiceContract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressRestController {

    private static final Logger logger = LoggerFactory.getLogger(AddressRestController.class);
    private final AddressServiceContract addressServiceContract;

    @Autowired
    public AddressRestController(AddressServiceContract addressServiceContract) {
        this.addressServiceContract = addressServiceContract;
    }


    @GetMapping
    //@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
    public List<Address> getAddresses() {
        try {
            return addressServiceContract.findAll();
        } catch (AddressNotFoundException ex){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "No Addresses found",ex);
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    //@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE') or hasRole('ROLE_CLIENT')")
    public Address retrieveAddress(@PathVariable Integer id){
        logger.debug("Get address by id : ", id);
        try {
            return addressServiceContract.findById(id);
        } catch (AddressNotFoundException ex){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found",ex);

        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
    public ResponseEntity<Void> createNewAddress(@Valid @RequestBody Address newAddress){
        if (newAddress == null){
            return ResponseEntity.noContent().build();
        }

        Address addressToSave = addressServiceContract.save(newAddress);
        URI location = ServletUriComponentsBuilder
                               .fromCurrentRequest()
                               .path("/{id}")
                               .buildAndExpand(addressToSave.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    //@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
    public Address updateAddress(@PathVariable Integer id, @RequestBody Address address){
        try {
            return addressServiceContract.update(address);
        } catch (AddressNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide correct Address Id", ex);
        }
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteAddress(@PathVariable Integer id){
        addressServiceContract.deleteById(id);
    }




}
