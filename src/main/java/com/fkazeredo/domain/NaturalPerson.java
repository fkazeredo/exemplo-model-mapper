package com.fkazeredo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@ToString
@EqualsAndHashCode(callSuper = true)
public class NaturalPerson extends Person {

    private String cpf;

    private String rg;

    private String ctps;

    private PersonName personName;

    public NaturalPerson(Long id, String cpf, PersonName personName, Contact email) {
        super(PersonType.NATURAL, null, null, email);
        this.id = id;
        this.cpf = cpf;
        this.personName = personName;
        this.enabled = true;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public void setPersonName(PersonName personName) {
        this.personName = personName;
    }

    protected NaturalPerson(){

    }
}
