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

    public MemberDTO updateMember(String id, MemberDTO memberDTO) {
        MemberEntity existingMember = memberRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Member not found with the provided ID"));

        existingMember.setName(memberDTO.getName());
        existingMember.setLastname(memberDTO.getLastname());
        existingMember.setDni(memberDTO.getDni());
        existingMember.setEmail(memberDTO.getEmail());
        existingMember.setBirthdate(memberDTO.getBirthdate());

        return memberParser.toMemberDTO(memberRepository.save(existingMember));
    }

    public Page<MemberDTO> searchByLastname(String lastname, Pageable pageable) {
        Page<MemberEntity> resultMemberEntities = memberRepository.findByLastnameContainingIgnoreCase(lastname, pageable);
        return resultMemberEntities.map(memberParser::toMemberDTO);
    }

    public Page<MemberDTO> searchByDni(String dni, Pageable pageable) {
        Page<MemberEntity> resultMemberEntities = memberRepository.findByDniContainingIgnoreCase(dni, pageable);
        return resultMemberEntities.map(memberParser::toMemberDTO);
    }
}
