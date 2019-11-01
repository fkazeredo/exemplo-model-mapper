package com.fkazeredo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CountryData implements Serializable {

    private static final long serialVersionUID = -8874800447958870331L;

    private Long id;
    private String name;
    private String fullName;
    private String callingCode;
    private String currencyCode;
    private String iso;
    private String iso3;
    private Boolean enabled;

}
