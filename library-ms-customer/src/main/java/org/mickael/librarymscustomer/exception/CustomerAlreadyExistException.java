package org.mickael.librarymscustomer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Conflict : Customer already exist")
public class CustomerAlreadyExistException extends Exception {

    private static final long serialVersionUID = 1L;
    public CustomerAlreadyExistException(String errorMessage) {
        super(errorMessage);
    }
}
