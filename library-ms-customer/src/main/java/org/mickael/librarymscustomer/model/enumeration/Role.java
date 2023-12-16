package org.mickael.librarymscustomer.model.enumeration;

public enum Role {

    ADMIN("ADMIN"),
    EMPLOYEE("EMPLOYEE"),
    CLIENT("CLIENT"),
    BATCH("BATCH");

    private String abbreviation ;

    Role(String abbreviation) {
        this.abbreviation = abbreviation ;
    }

    public String getAbbreviation() {
        return  this.abbreviation ;
    }
}
