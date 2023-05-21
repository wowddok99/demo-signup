package com.example.demosignup.exception;

import com.example.demosignup.exception.support.CustomException;
import com.example.demosignup.exception.support.ErrorCode;

public class MemberException extends CustomException {
    public MemberException() {
        super();
    }

    public MemberException(String message) {
        super(message);
    }

    public MemberException(String message, Throwable cause) {
        super(message, cause);
    }

    public MemberException(ErrorCode errorCode) {
        super(errorCode);
    }

    public MemberException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
