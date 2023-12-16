package org.mickael.librarymscustomer.model.enumeration;

public enum Permission {

    READ("READ"),
    WRITE("WRITE"),
    UPDATE("UPDATE"),
    DELETE("DELETE");

    private String abbreviation ;

    Permission(String abbreviation) {
        this.abbreviation = abbreviation ;
    }

    public String getAbbreviation() {
        return  this.abbreviation ;
    }
}
