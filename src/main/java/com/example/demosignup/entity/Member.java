package com.example.demosignup.entity;

import java.time.OffsetDateTime;

import com.example.demosignup.entity.type.MemberStatus;
import com.example.demosignup.support.persistence.BaseEntity;
import com.example.demosignup.util.time.ServerTime;

// javax -> jakarta
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity {
    public String username;
    public String password;
    public String nickname;
    public Integer age;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    public MemberStatus status = MemberStatus.PENDING;

    @Builder.Default
    public OffsetDateTime joinDate = ServerTime.now();
}

// Member.builder()
//         .username("...")
//         .password("...")
//         .nickname("...")
//         .age(...)
//         .build();