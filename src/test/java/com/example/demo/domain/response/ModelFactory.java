package com.example.demo.domain.response;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.model.Member;
import com.example.demo.domain.model.Team;

public class ModelFactory {

    private static Member createMember() {
        return Member.builder()
                .id(1L)
                .name("Membro 1")
                .createdAt(LocalDate.now())
                .updatedAt(LocalDate.now())
                .build();
    }

    private static Team createTeam() {
        return Team.builder()
                .id(1L)
                .name("Time 1")
                .createdAt(LocalDate.now())
                .updatedAt(LocalDate.now())
                .build();
    }

    public static Member memberFactory() {
        final Member member = createMember();

        final Team team = createTeam();

        final List<Member> memberList = new ArrayList<>();

        memberList.add(member);
        team.setMembers(memberList);

        member.setTeam(team);

        return member;
    }

    public static Team teamFactory(){
        return memberFactory().getTeam();
    }

}
