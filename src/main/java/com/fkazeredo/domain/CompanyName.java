package com.fkazeredo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@ToString
@EqualsAndHashCode
public class CompanyName {

    private String tradingName;

    private String legalName;

	public CompanyName(String tradingName, String legalName) {
		this.tradingName = tradingName;
		this.legalName = legalName;
	}
	
	protected CompanyName() {
	}

}
