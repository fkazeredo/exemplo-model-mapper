package com.fkazeredo.domain;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Accessors(fluent = true)
@ToString
@EqualsAndHashCode(callSuper = true)
public class Person extends Entity {

    private static final long serialVersionUID = 559892657872514964L;

    private PersonType type;

    @Getter(AccessLevel.PRIVATE)
    private Set<Address> addresses;

    @Getter(AccessLevel.PRIVATE)
    private Set<Contact> contacts;

    protected Person(Long id, PersonType type, Address address, Contact phoneNumber, Contact email) {
        this(type, address, phoneNumber, email);
        this.id = id;
    }

    protected Person(PersonType type, Address address, Contact phoneNumber, Contact email) {
        super();
        this.type = type;
        if (address != null)
            this.setAddress(address);
        if (phoneNumber != null)
            this.setPhoneNumber(phoneNumber);
        if (email != null)
            this.setEmail(email);
    }

    public Address address() {
        return this.addresses.stream()
                .filter(Objects::nonNull)
                .findAny()
                .orElse(null);
    }

    public void setAddress(Address address) {
        if (this.addresses == null)
            this.addresses = new HashSet<>();
        this.addresses.clear();
        this.addresses.add(address);
    }


    public String phoneNumber() {
        String value = null;
        List<Contact> data = contacts.stream()
                .filter(Objects::nonNull)
                .filter(c -> c.type().equals(ContactType.PHONE_NUMBER))
                .collect(Collectors.toList());
        if (data.size() > 1)
            throw new IllegalStateException("More than one Phone Number found");
        else if (data.size() == 1)
            value = data.get(0).value();
        return value;
    }

    public void setPhoneNumber(Contact phoneNumber) {
        if (this.contacts == null)
            this.contacts = new HashSet<>();
        this.contacts.removeAll(
                contacts.stream()
                        .filter(c -> c.type().equals(ContactType.PHONE_NUMBER))
                        .collect(Collectors.toList())
        );
        this.contacts.add(phoneNumber);
    }

    public String email() {
        String value = null;
        List<Contact> data = contacts.stream()
                .filter(Objects::nonNull)
                .filter(c -> c.type().equals(ContactType.EMAIL))
                .collect(Collectors.toList());
        if (data.size() > 1)
            throw new IllegalStateException("More than one E-mail found");
        else if (data.size() == 1)
            value = data.get(0).value();
        return value;
    }

    public void setEmail(Contact email) {
        if (this.contacts == null)
            this.contacts = new HashSet<>();
        this.contacts.removeAll(
                contacts.stream()
                        .filter(c -> c.type().equals(ContactType.EMAIL))
                        .collect(Collectors.toList())
        );
        this.contacts.add(email);
    }

    protected Person() {

    }

}
