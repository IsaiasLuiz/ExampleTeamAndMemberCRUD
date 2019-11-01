package com.example.demo.controler;

import java.util.List;

import com.example.demo.unitary.domain.exception.TeamNotFoundException;
import com.example.demo.unitary.domain.request.MemberRequest;
import com.example.demo.unitary.domain.request.MemberRequestUpdate;
import com.example.demo.unitary.domain.response.MemberResponse;
import com.example.demo.service.Member.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/member")
@RestController
public class MemberController {

    @Autowired
    private MemberServiceImpl memberService;

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody final MemberRequest memberRequest) throws TeamNotFoundException {
        memberService.save(memberRequest);
    }

    @GetMapping
    public List<MemberResponse> listAll(@RequestParam final Integer page) {
        return memberService.listAll(page);
    }

    @GetMapping("/search")
    public MemberResponse searchById(@RequestParam final Long id) {
        return memberService.searchforId(id);
    }

    @ResponseStatus(code = HttpStatus.GONE)
    @DeleteMapping
    public void deleteById(@RequestParam final Long id) {
        memberService.deleteById(id);
    }

    @PutMapping
    public void update(@RequestBody final MemberRequestUpdate memberRequest) throws TeamNotFoundException {
        memberService.update(memberRequest);
    }

}
