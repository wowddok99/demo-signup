package com.example.demosignup.service.usecase;

import com.example.demosignup.api.dto.MemberCommandDto.MemberSignUpRequestDto;
import com.example.demosignup.entity.Member;
import com.example.demosignup.entity.type.MemberStatus;

public interface MemberSignUpUseCase {
    Member signUp(Member member);
    Member signUp(MemberSignUpRequestDto dto, MemberStatus status);
}
