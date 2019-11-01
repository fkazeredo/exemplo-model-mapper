package com.fkazeredo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressData {

    private String zipCode;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private IdAndNameData city;
    private IdAndNameData region;
    private IdAndNameData country;

}
