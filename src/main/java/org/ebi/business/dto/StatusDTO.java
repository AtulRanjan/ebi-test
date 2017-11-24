package org.ebi.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StatusDTO {
	private Integer code;
	private String message;
}
