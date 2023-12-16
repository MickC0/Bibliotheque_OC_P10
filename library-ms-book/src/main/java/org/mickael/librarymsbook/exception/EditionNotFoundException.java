package org.mickael.librarymsbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Book Not Found")
public class EditionNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public EditionNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
