package com.example.demosignup.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

import static com.example.demosignup.entity.MemberValidationConstants.USERNAME_PATTERN;

import com.fasterxml.jackson.annotation.JsonProperty;

import static com.example.demosignup.entity.MemberValidationConstants.USERNAME_MESSAGE;
import static com.example.demosignup.entity.MemberValidationConstants.NICKNAME_PATTERN;
import static com.example.demosignup.entity.MemberValidationConstants.NICKNAME_MESSAGE;
import static com.example.demosignup.entity.MemberValidationConstants.PASSWORD_PATTERN;
import static com.example.demosignup.entity.MemberValidationConstants.PASSWORD_MESSAGE;

public class MemberCommandDto {

    // for immutable object
    public record MemberSignUpRequestDto(
            @Pattern(regexp = USERNAME_PATTERN, message = USERNAME_MESSAGE)
            String username,

            // @NotBlank
            @Pattern(regexp = NICKNAME_PATTERN, message = NICKNAME_MESSAGE)
            String nickname,

            @JsonProperty("password")
            @Pattern(regexp = PASSWORD_PATTERN, message = PASSWORD_MESSAGE)
            String rawPassword,
            
            @Min(0)
            Integer age
    ) {}

    // 우리가 직접 생성 취급 -> 생성자 직접 쓰면 -> 나중에 스펙 바뀌면 -> 다 수정하러 가 줘야.
    @Builder
    public record MemberSignUpResponseDto(
        Boolean success
    ) {}
}
