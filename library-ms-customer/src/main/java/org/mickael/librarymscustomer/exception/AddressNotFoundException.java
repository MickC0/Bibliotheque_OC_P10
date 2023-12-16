package org.mickael.librarymscustomer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Address Not Found")
public class AddressNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;
    public AddressNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
