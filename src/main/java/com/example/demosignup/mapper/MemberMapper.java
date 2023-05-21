package com.example.demosignup.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.demosignup.api.dto.MemberCommandDto.MemberSignUpRequestDto;
import com.example.demosignup.entity.Member;
import com.example.demosignup.entity.type.MemberStatus;

@Mapper // (componentModel = "spring")
public interface MemberMapper {
    @Mappings({
        @Mapping(target = "password", source = "dto.rawPassword")
    })
    Member from(MemberSignUpRequestDto dto, MemberStatus status);
}
