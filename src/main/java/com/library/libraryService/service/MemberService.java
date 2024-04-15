package com.library.libraryService.service;

import com.library.libraryService.model.BookDTO;
import com.library.libraryService.model.BookEntity;
import com.library.libraryService.model.MemberDTO;
import com.library.libraryService.model.MemberEntity;
import com.library.libraryService.parser.BookParser;
import com.library.libraryService.parser.MemberParser;
import com.library.libraryService.repository.BookRepository;
import com.library.libraryService.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberParser memberParser;

    public MemberDTO saveMember(MemberDTO memberDTO) {
        MemberEntity memberEntity = memberParser.toMemberEntity(memberDTO);
        MemberEntity savedMember = memberRepository.save(memberEntity);
        return memberParser.toMemberDTO(savedMember);
    }

    public Page<MemberDTO> getAllMembers(Pageable pageable) {
        return memberRepository.findAll(pageable).map(memberParser::toMemberDTO);
    }
}
