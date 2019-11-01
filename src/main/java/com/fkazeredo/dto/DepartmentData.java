package com.fkazeredo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class DepartmentData implements Serializable {

    private static final long serialVersionUID = 4592727087800100542L;

    private Long id;
    private String name;
    private String description;
    private IdAndNameData company;
    private Boolean enabled;

}
