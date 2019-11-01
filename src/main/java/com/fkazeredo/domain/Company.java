package com.fkazeredo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString
public class Company extends Entity {

    private static final long serialVersionUID = 4956961921296347766L;

    private JuridicalPerson companyInfo;

    private String description;

    public Company(JuridicalPerson companyInfo, String decription) {
        this.companyInfo = companyInfo;
        this.description = decription;
        this.enabled = true;
    }

    public Company(Long id, JuridicalPerson companyInfo, String decription) {
        this(companyInfo, decription);
        this.id = id;
    }

    public void editCompanyDetails(
            String cnpj, CompanyName companyName, Address address, Contact email, Contact phoneNumber) {

        assertEnablement();

        this.companyInfo().setCnpj(cnpj);
        this.companyInfo().setCompanyName(companyName);
        this.companyInfo().setAddress(address);
        this.companyInfo().setEmail(email);
        this.companyInfo().setPhoneNumber(phoneNumber);

    }

    public void editRepresentativeDetails(
            String representativeCPF, PersonName representativeName, Contact representativeEmail) {

        assertEnablement();

        this.companyInfo().setRepresentativeCpf(representativeCPF);
        this.companyInfo().setRepresentativeName(representativeName);
        this.companyInfo().setRepresentativeEmail(representativeEmail);

    }

    public void changeDescription(String description){

        assertEnablement();
        this.description = description;

    }

    private void assertEnablement() {

        if (!this.enabled)
            throw new ResourceIsDisabledException(getClass().getSimpleName(), this.id);

    }

    protected Company() {
    }

}
