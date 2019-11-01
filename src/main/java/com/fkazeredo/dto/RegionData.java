package com.fkazeredo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class RegionData implements Serializable {

    private static final long serialVersionUID = -1135587087840009804L;

    private Long id;
    private String code;
    private String name;
    private IdAndNameData country;
    private Boolean enabled;

}
