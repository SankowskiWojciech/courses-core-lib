package com.github.sankowskiwojciech.coursescorelib.model.exception;

public class SubdomainNotFoundDetailedException extends DetailedException {
    private static final int STATUS_CODE = 404;
    private static final String ERROR_CODE = "SUBDOMAIN_NOT_FOUND";
    private static final String ERROR_MESSAGE = "Subdomain with given name not found.";

    public SubdomainNotFoundDetailedException() {
        super(STATUS_CODE, ERROR_CODE, ERROR_MESSAGE);
    }
}
