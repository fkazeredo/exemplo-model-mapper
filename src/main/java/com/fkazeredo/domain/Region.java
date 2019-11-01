package com.fkazeredo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString
public class Region extends Entity {

	private static final long serialVersionUID = -2148572955607588321L;

	private String code;

	private String name;

	private Country country;

	public Region(String code, String name, Country country) {
		this.code = code;
		this.name = name;
		this.country = country;
		this.enabled = true;
	}

	public Region(Long id, String code, String name, Country country) {
		this(code, name, country);
		this.id = id;
	}

	public void editDetails(String code, String name) {
		assertEnablement();
		this.code = code;
		this.name = name;
	}

	public void enable() {
		assertCountryEnablement();
		super.enable();
	}

	public void disable() {
		assertCountryEnablement();
		super.disable();
	}

	private void assertCountryEnablement() {
		if (!this.country.enabled())
			throw new ResourceIsDisabledException(Country.class.getSimpleName(), this.country.id());
	}

	private void assertEnablement() {
		if (!this.country.enabled())
			throw new ResourceIsDisabledException(Country.class.getSimpleName(), this.country.id());
		if (!this.enabled)
			throw new ResourceIsDisabledException(getClass().getSimpleName(), this.country.id());
	}

	protected Region() {
	}

}
