package com.library.libraryService.controller;

import com.library.libraryService.model.BookDTO;
import com.library.libraryService.model.MemberDTO;
import com.library.libraryService.service.BookService;
import com.library.libraryService.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;

    @PostMapping
    public MemberDTO saveMember(@RequestBody MemberDTO memberDTO) {
        return memberService.saveMember(memberDTO);
    }

    @GetMapping
    public Page<MemberDTO> getAllMembers(Pageable pageable) {
        return memberService.getAllMembers(pageable);
    }
}

