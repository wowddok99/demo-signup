package com.example.demosignup.entity;

public final class MemberValidationConstants {
    public static final String USERNAME_PATTERN = "^[a-zA-Z][a-zA-Z0-9]{2,30}$";
    public static final String USERNAME_MESSAGE = "계정은 영문으로 시작하여야 하며, 영문, 숫자를 포함하여 최소 3글자 이상 작성하시기 바랍니다.";
    public static final String NICKNAME_PATTERN = "^[가-힣a-zA-Z]{2,50}$";
    public static final String NICKNAME_MESSAGE = "이름은 완성된 한글만 허용하며, 2글자 이상 입력하시기 바랍니다.";
    public static final String PASSWORD_PATTERN = "^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,100}$";
    public static final String PASSWORD_MESSAGE = "비밀번호는 영문, 숫자, 특수문자를 조합하여 8자리 이상으로 작성하시기 바랍니다.";

    private MemberValidationConstants() {}
}
