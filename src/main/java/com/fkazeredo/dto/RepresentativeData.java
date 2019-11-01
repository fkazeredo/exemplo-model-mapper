package com.fkazeredo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class RepresentativeData implements Serializable {

    private static final long serialVersionUID = -352355801113052003L;

    private String cpf;
    private String rg;
    private String firstName;
    private String lastName;
    private String email;

}
