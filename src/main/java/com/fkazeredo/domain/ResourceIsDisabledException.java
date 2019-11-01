package com.fkazeredo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ResourceIsDisabledException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -5416371571159955572L;

    private String resource;

    private Long id;

    public ResourceIsDisabledException(String resource, Long id) {
        this.resource = resource.toLowerCase();
        this.id = id;
    }
}
