package com.lothin.phoneshp.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class ResourceNotFoundException extends ApiException {
    private String resourceName;
    private Integer resourceId;

    public ResourceNotFoundException(String resourceName, Integer resourceId) {
        super(HttpStatus.NOT_FOUND, String.format("%s Not Found for id=%d", resourceName, resourceId));
    }
}
