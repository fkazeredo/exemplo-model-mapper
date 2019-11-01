package com.fkazeredo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString
public class City extends Entity {

	private static final long serialVersionUID = 7490138142122244L;

	private String name;

	private Region region;

	private Country country;

	public City(String name, Region region, Country country) {
		this.name = name;
		this.region = region;
		this.country = country;
		this.enabled = true;
	}

	public City(Long id, String name, Region region, Country country) {
		this(name, region, country);
		this.id = id;
	}

	public void enable() {
		assertCountryAndRegionEnablement();
		super.enable();
	}

	public void disable() {
		assertCountryAndRegionEnablement();
		super.disable();
	}

	public void changeName(String name) {
		assertEnablement();
		this.name = name;
	}

	private void assertCountryAndRegionEnablement() {
		if (!this.country.enabled())
			throw new ResourceIsDisabledException(Country.class.getSimpleName(), this.country.id());
		if (this.region != null && !this.region.enabled())
			throw new ResourceIsDisabledException(Region.class.getSimpleName(), this.region.id());
	}

	private void assertEnablement() {
		if (!this.country.enabled())
			throw new ResourceIsDisabledException(Country.class.getSimpleName(), this.country.id());
		if (this.region != null && !this.region.enabled())
			throw new ResourceIsDisabledException(Region.class.getSimpleName(), this.region.id());
		if (!this.enabled)
			throw new ResourceIsDisabledException(getClass().getSimpleName(), this.country.id());
	}

	protected City() {
	}

}
