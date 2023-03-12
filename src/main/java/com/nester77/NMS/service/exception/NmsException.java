package com.nester77.NMS.service.exception;

public class NmsException extends RuntimeException{
    public NmsException() {
    }

    public NmsException(String message) {
        super(message);
    }

    public NmsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NmsException(Throwable cause) {
        super(cause);
    }
}
