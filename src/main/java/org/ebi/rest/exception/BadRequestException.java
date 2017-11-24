package org.ebi.rest.exception;

import lombok.Getter;
import org.ebi.business.dto.StatusDTO;

@Getter
public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final StatusDTO errorMessage;

    public BadRequestException(StatusDTO message) {
        super();
        this.errorMessage =  message;
    }

    public  BadRequestException(Integer code, String message) {
        super();
        this.errorMessage = new StatusDTO(code, message);
    }

}
