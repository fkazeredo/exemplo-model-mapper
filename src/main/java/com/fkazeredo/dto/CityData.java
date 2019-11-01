package com.fkazeredo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CityData implements Serializable {

    private static final long serialVersionUID = 5944015067437108041L;

    private Long id;
    private String name;
    private IdAndNameData region;
    private IdAndNameData country;
    private Boolean enabled;

}
