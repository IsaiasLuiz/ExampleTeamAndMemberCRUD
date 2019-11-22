package com.example.demo.domain.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.example.demo.domain.model.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class MemberResponseTest {

    @Test
    void converterToResponse() {
        final Member member = ModelFactory.memberFactory();
        final MemberResponse response = new MemberResponse().converterToResponse(member);
        assertNotEquals(response, null);
        assertEquals(response.getId(), member.getId());
        assertEquals(response.getName(), member.getName());
        assertEquals(response.getCreatedAt(), member.getCreatedAt());
        assertEquals(response.getUpdatedAt(), member.getUpdatedAt());
    }

}