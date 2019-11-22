package com.example.demo.controler;

import java.util.List;

import com.example.demo.domain.request.TeamRequest;
import com.example.demo.domain.response.TeamResponse;
import com.example.demo.service.Team.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/team")
@RestController
public class TeamController {

    @Autowired
    private TeamServiceImpl teamService;

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody final TeamRequest team) {
        teamService.save(team);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    @GetMapping
    public List<TeamResponse> listAll(@RequestParam final Integer page) {
        return teamService.listAll(page);
    }

    @ResponseBody
    @GetMapping("/search")
    public TeamResponse searchForId(@RequestParam final Long id) {
        return teamService.searchforId(id);
    }
}
