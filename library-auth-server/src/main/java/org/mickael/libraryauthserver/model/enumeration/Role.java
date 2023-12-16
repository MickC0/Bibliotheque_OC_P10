package org.mickael.libraryauthserver.model.enumeration;

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
