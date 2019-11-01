package com.fkazeredo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@ToString
@EqualsAndHashCode
public class PersonName {

    private String firstName;

    private String lastName;

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public PersonName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    protected PersonName(){
    }

}
