package com.fkazeredo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CompanyData implements Serializable {

    private static final long serialVersionUID = -352355801113052003L;

    private Long id;
    private String cnpj;
    private String tradingName;
    private String legalName;
    private String phoneNumber;
    private String email;
    private String description;
    private AddressData address;
    private RepresentativeData representative;
    private Boolean enabled;

}
