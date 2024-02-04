package org.enes.exception;

import lombok.Getter;

@Getter
public class TryMeAppException extends RuntimeException{

    private final ErrorType errorType;

    public TryMeAppException(ErrorType errorType,String customMessage ) {
        super(customMessage);
        this.errorType = errorType;
    }

    public TryMeAppException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}
