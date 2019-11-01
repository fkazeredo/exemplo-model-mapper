package com.fkazeredo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@ToString
@EqualsAndHashCode
public class Contact {

    private ContactType type;

    private String value;

	public Contact(ContactType type, String value) {
		super();
		this.type = type;
		this.value = value;
	}
    
    protected Contact(){

	}

}
