package com.example.demo.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Component
@Data
public class MemberRequestUpdate {

    private Long id;

    private String name;

    private Long idTeam;

}
