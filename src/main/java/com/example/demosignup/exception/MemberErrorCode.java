package com.example.demosignup.exception;

import com.example.demosignup.exception.support.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum MemberErrorCode implements ErrorCode {
    NICKNAME_ALREADY_USED("이미 사용 중인 닉네임입니다.", HttpStatus.CONFLICT),
    USERNAME_ALREADY_USED("이미 사용 중인 계정입니다.", HttpStatus.CONFLICT),
    DEFAULT("회원 관련 오류", HttpStatus.INTERNAL_SERVER_ERROR);

    public final String MESSAGE;
    public final HttpStatus STATUS;

    @Override
    public HttpStatus defaultHttpStatus() {
        return STATUS;
    }

    @Override
    public String defaultMessage() {
        return MESSAGE;
    }

    @Override
    public MemberException defaultException() {
        return new MemberException(this);
    }

    @Override
    public MemberException defaultException(Throwable cause) {
        return new MemberException(this, cause);
    }
}