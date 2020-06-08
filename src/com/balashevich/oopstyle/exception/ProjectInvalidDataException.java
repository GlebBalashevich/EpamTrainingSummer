package com.balashevich.oopstyle.exception;

public class ProjectInvalidDataException extends RuntimeException {
    public ProjectInvalidDataException() {
        super();
    }

    public ProjectInvalidDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
