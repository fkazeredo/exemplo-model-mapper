package com.fkazeredo.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString
public class Country extends Entity {

    private static final long serialVersionUID = 8320266324472801246L;

    private String name;

    private String fullName;

    private String callingCode;

    private String currencyCode;

    private String iso;

    private String iso3;

    public Country(String name, String iso3) {
        this.name = name;
        this.iso3 = iso3;
        this.enabled = true;
    }

    public Country(Long id, String name, String iso3) {
        this(name, iso3);
        this.id = id;
    }

    public void changeName(String name, String fullName){

        assertEnablement();

        this.name = name;
        this.fullName = fullName;

    }

    public void changeCodes(String callingCode, String currencyCode, String iso, String iso3){

        assertEnablement();

        this.callingCode = callingCode;
        this.currencyCode = currencyCode;
        this.iso = iso;
        this.iso3 = iso3;

    }

    protected Country() {
    }

    private void assertEnablement() {
        if (!this.enabled)
            throw new ResourceIsDisabledException(getClass().getSimpleName(), this.id);
    }

}
