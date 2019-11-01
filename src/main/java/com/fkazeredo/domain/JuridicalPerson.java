package com.fkazeredo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@ToString
@EqualsAndHashCode(callSuper = true)
public class JuridicalPerson extends Person {

	private static final long serialVersionUID = -2605716640948273559L;

	private String cnpj;

	private CompanyName companyName;

	private NaturalPerson representative;

	public JuridicalPerson(Long id, String cnpj, CompanyName companyName, Address address, Contact phoneNumber, Contact email, NaturalPerson representative) {
		super(PersonType.JURIDICAL, address, phoneNumber, email);
		this.id = id;
		this.cnpj = cnpj;
		this.companyName = companyName;
		this.representative = representative;
		this.enabled = true;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setCompanyName(CompanyName companyName) {
		this.companyName = companyName;
	}

	public void setRepresentativeCpf(String cpf){
		this.representative.setCpf(cpf);
	}

	public void setRepresentativeName(PersonName personName){
		this.representative.setPersonName(personName);
	}

	public void setRepresentativeEmail(Contact representativeEmail) {
		this.representative.setEmail(representativeEmail);
	}

	protected JuridicalPerson(){
	}

}
