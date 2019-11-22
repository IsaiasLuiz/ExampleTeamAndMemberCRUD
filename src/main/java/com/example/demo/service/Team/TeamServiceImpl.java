package com.example.demo.service.Team;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.domain.model.Team;
import com.example.demo.domain.request.TeamRequest;
import com.example.demo.domain.response.TeamResponse;
import com.example.demo.repository.TeamRepository;
import com.example.demo.service.ServiceDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements ServiceDefault<TeamRequest, TeamResponse> {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamResponse teamResponse;

    public void save(final TeamRequest request) {

        Team team = Team.builder()
                .name(request.getName())
                .build();

        teamRepository.save(team);
    }

    public List<TeamResponse> listAll(final Integer page) {
        final PageRequest pageable = PageRequest.of(page - 1, 10);

        return teamRepository.findAll(pageable)
                .getContent()
                .stream()
                .map(teamResponse::converterToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TeamResponse searchforId(final Long id) {
        final Optional<Team> teamOptional = teamRepository.findById(id);

        return teamOptional.isPresent() ? teamResponse.converterToResponse(teamOptional.get()) : null;

    }

}
