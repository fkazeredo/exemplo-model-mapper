package com.fkazeredo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class IdAndNameData implements Serializable {

	private static final long serialVersionUID = 8426130664990811511L;

	private Long id;
	private String name;

}
