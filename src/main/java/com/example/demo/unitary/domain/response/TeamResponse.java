package com.example.demo.unitary.domain.response;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.unitary.domain.MapperConverter;
import com.example.demo.unitary.domain.model.Member;
import com.example.demo.unitary.domain.model.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
@Getter
@Setter
public class TeamResponse implements MapperConverter<Team, TeamResponse> {

    private Long id;

    private String name;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private List<Member> memberList;

    @Override
    public TeamResponse converterToResponse(final Team team) {

        return TeamResponse.builder()
                .id(team.getId())
                .name(team.getName())
                .createdAt(team.getCreatedAt())
                .updatedAt(team.getUpdatedAt())
                .memberList(team.getMembers())
                .build();
    }

}
