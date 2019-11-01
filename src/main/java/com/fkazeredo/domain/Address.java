package com.fkazeredo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@ToString
@EqualsAndHashCode
public class Address {

    private String zipCode;

    private String street;

    private String number;

    private String complement;

    private String neighborhood;

    private City city;

    public Address(String zipCode, String street, String number, String complement, String neighborhood, City city) {
        super();
        this.zipCode = zipCode;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
    }

    protected Address(){
    }

}
