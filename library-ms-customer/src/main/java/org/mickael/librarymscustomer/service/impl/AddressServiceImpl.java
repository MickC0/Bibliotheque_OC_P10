package org.mickael.librarymscustomer.service.impl;


import org.mickael.librarymscustomer.exception.AddressNotFoundException;
import org.mickael.librarymscustomer.model.Address;
import org.mickael.librarymscustomer.repository.AddressRepository;
import org.mickael.librarymscustomer.service.contract.AddressServiceContract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressServiceContract {

    private static final Logger logger = LoggerFactory.getLogger(AddressServiceContract.class);
    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public List<Address> findAll() throws AddressNotFoundException {
        List<Address> addresses = addressRepository.findAll();
        if(addresses.isEmpty()){
            throw new AddressNotFoundException("No address found");
        }
        return addresses;
    }

    @Override
    public Address findById(Integer id) throws AddressNotFoundException {
        Optional<Address> address = addressRepository.findById(id);
        if (!address.isPresent()){
            throw new AddressNotFoundException("Address not found in repository");
        }
        return address.get();
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address) throws AddressNotFoundException {
        Optional<Address> optionalAddress = addressRepository.findById(address.getId());
        if (!optionalAddress.isPresent()){
            throw new AddressNotFoundException("Address not found in repository");
        }
        return addressRepository.save(address);
    }

    @Override
    public void deleteById(Integer id) {
        addressRepository.deleteById(id);
    }
}
