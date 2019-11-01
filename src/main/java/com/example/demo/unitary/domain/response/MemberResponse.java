package com.example.demo.unitary.domain.response;

import java.time.LocalDate;

import com.example.demo.unitary.domain.MapperConverter;
import com.example.demo.unitary.domain.model.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
@Data
public class MemberResponse implements MapperConverter<Member, MemberResponse> {

    private Long id;

    private String name;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    @Override
    public MemberResponse converterToResponse(final Member member) {
        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .createdAt(member.getCreatedAt())
                .updatedAt(member.getUpdatedAt())
                .build();
    }
}
