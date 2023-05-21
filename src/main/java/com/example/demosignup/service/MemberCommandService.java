package com.example.demosignup.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demosignup.api.dto.MemberCommandDto.MemberSignUpRequestDto;
import com.example.demosignup.entity.Member;
import com.example.demosignup.entity.type.MemberStatus;
import com.example.demosignup.exception.MemberErrorCode;
import com.example.demosignup.mapper.MemberMapper;
import com.example.demosignup.repository.MemberRepository;
import com.example.demosignup.service.usecase.MemberSignUpUseCase;

import lombok.RequiredArgsConstructor;

import static com.example.demosignup.util.validation.Preconditions.validate;

@Service
@RequiredArgsConstructor
public final class MemberCommandService implements MemberSignUpUseCase {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final MemberMapper memberMapper;

    @Override
    public Member signUp(Member member) { // 확장성 O, 편의성은 좀 덜함.
        // validate(!memberRepository.existsByUsername(member.username), MemberErrorCode.USERNAME_ALREADY_USED);
        if (memberRepository.existsByUsername(member.username)) {
            throw MemberErrorCode.USERNAME_ALREADY_USED.defaultException();
        }
        if (memberRepository.existsByNickname(member.nickname)) {
            throw MemberErrorCode.NICKNAME_ALREADY_USED.defaultException();
        }

        member.password = passwordEncoder.encode(member.password);
        return memberRepository.save(member);
    }

    // 편의성은 있는데, DTO를 직접 쓰기 때문에 확장성에는 덜 좋음.
    @Override
    public Member signUp(MemberSignUpRequestDto dto, MemberStatus status) {
        Member member = memberMapper.from(dto, status);
        return signUp(member);
    }
}
