package com.basicproject.boardservice.data.dto;

import com.basicproject.boardservice.data.entity.Member;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class MemberDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class LoginRequest {


        @NotNull
        private String memberName;

        @NotNull
        private String password;

    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {

        private Long id;

        /*login id*/

        @NotBlank
        private String memberName;

        private String password;

        private String nickName;

        private String email;

        public Member toEntity() {
            Member member = Member.builder()
                .id(this.id)
                .memberName(this.memberName)
                .password(this.password)
                .nickName(this.nickName)
                .build();

            return member;
        }

    }

}
