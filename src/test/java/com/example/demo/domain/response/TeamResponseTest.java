package com.example.demo.domain.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.example.demo.domain.model.Team;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class TeamResponseTest {

    @Test
    void converterToResponse() {
        final Team team = ModelFactory.teamFactory();
        final TeamResponse response = new TeamResponse().converterToResponse(team);

        assertNotEquals(response, null);
        assertNotEquals(response.getMemberList(), null);
        assertEquals(response.getId(), team.getId());
        assertEquals(response.getName(), team.getName());
        assertEquals(response.getCreatedAt(), team.getCreatedAt());
        assertEquals(response.getUpdatedAt(), team.getUpdatedAt());
        assertEquals(response.getMemberList(), team.getMembers());

    }
}