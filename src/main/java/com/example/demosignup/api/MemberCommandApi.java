package com.example.demosignup.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demosignup.api.dto.MemberCommandDto.MemberSignUpRequestDto;
import com.example.demosignup.api.dto.MemberCommandDto.MemberSignUpResponseDto;
import com.example.demosignup.entity.type.MemberStatus;
import com.example.demosignup.service.usecase.MemberSignUpUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor // final, non(not)-null
public final class MemberCommandApi {
    private final MemberSignUpUseCase memberSignUpUseCase;

    @PostMapping("/sign-up")
    public MemberSignUpResponseDto signUp(@RequestBody @Valid MemberSignUpRequestDto body) {
        memberSignUpUseCase.signUp(body, MemberStatus.ACTIVE);

        return MemberSignUpResponseDto.builder()
                .success(true)
                .build();
    }
}
