package org.mickael.librarymscustomer.service.contract;


import org.mickael.librarymscustomer.exception.AddressNotFoundException;
import org.mickael.librarymscustomer.model.Address;

import java.util.List;

public interface AddressServiceContract {

    List<Address> findAll() throws AddressNotFoundException;
    Address findById (Integer id) throws AddressNotFoundException;
    Address save(Address address);
    Address update(Address address) throws AddressNotFoundException;
    void deleteById(Integer id);
}
