package org.mickael.librarymsbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Book Not Found")
public class CopyNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public CopyNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
