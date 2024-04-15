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

    @GetMapping
    public Page<MemberDTO> search(@RequestParam(required = false) String lastname,
                                @RequestParam(required = false) String dni,
                                Pageable pageable) {
        if (lastname != null) {
            return memberService.searchByLastname(lastname, pageable);
        } else if (dni != null) {
            return memberService.searchByDni(dni, pageable);
        } else {
            return memberService.getAllMembers(pageable);
        }
    }
    @PostMapping
    public MemberDTO saveMember(@RequestBody MemberDTO memberDTO) {
        return memberService.saveMember(memberDTO);
    }

    @PutMapping("/{id}")
    public MemberDTO updateMember(@PathVariable String id, @RequestBody MemberDTO memberDTO) {
        return memberService.updateMember(id, memberDTO);
    }
}

