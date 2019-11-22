package com.example.demo.service.Member;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.TeamRepository;
import com.example.demo.service.ServiceDefault;
import com.example.demo.domain.exception.MemberNotFoundException;
import com.example.demo.domain.exception.TeamNotFoundException;
import com.example.demo.domain.model.Member;
import com.example.demo.domain.model.Team;
import com.example.demo.domain.request.MemberRequest;
import com.example.demo.domain.request.MemberRequestUpdate;
import com.example.demo.domain.response.MemberResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements ServiceDefault<MemberRequest, MemberResponse> {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MemberResponse memberResponse;

    @Override
    public void save(final MemberRequest memberRequest) throws TeamNotFoundException {
        final Team team = checkTeamExists(memberRequest.getIdTeam());

        final Member member = Member.builder()
                .name(memberRequest.getName())
                .team(team)
                .build();

        memberRepository.save(member);

    }

    @Override
    public List<MemberResponse> listAll(final Integer page) {
        final PageRequest pageble = PageRequest.of(page - 1, 10);
        return memberRepository.findAll(pageble)
                .getContent()
                .stream()
                .map(memberResponse::converterToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public MemberResponse searchforId(final Long id) {
        final Optional<Member> member = memberRepository.findById(id);
        return member.isPresent() ? memberResponse.converterToResponse(member.get()) : null;
    }

    public void deleteById(final Long id) {
        memberRepository.deleteById(id);
    }

    public void update(final MemberRequestUpdate requestUpdate) throws TeamNotFoundException, MemberNotFoundException {
        if (!teamRepository.findById(requestUpdate.getId()).isPresent()) {
            throw new MemberNotFoundException(requestUpdate.getId());
        }

        final Team team = checkTeamExists(requestUpdate.getIdTeam());

        Member member = Member.builder()
                .name(requestUpdate.getName())
                .id(requestUpdate.getId())
                .team(team)
                .build();

        memberRepository.save(member);

    }

    private Team checkTeamExists(final Long id) throws TeamNotFoundException {
        final Optional<Team> teamOptional = teamRepository.findById(id);
        if (!teamOptional.isPresent()) {
            throw new TeamNotFoundException(id);
        }

        return teamOptional.get();
    }

}
