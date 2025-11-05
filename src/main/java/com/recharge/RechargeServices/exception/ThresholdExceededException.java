package com.recharge.RechargeServices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ThresholdExceededException extends RuntimeException {
    public ThresholdExceededException(String message) {
        super(message);
    }
}
