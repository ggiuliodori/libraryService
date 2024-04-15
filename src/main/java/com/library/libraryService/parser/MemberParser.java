package com.library.libraryService.parser;

import com.library.libraryService.model.MemberDTO;
import com.library.libraryService.model.MemberEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class MemberParser {

    public MemberDTO toMemberDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setName(memberEntity.getName());
        memberDTO.setLastname(memberEntity.getLastname());
        memberDTO.setDni(memberEntity.getDni());
        memberDTO.setEmail(memberEntity.getEmail());
        memberDTO.setBirthdate(memberEntity.getBirthdate());
        return memberDTO;
    }

    public MemberEntity toMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        memberEntity.setName(memberDTO.getName());
        memberEntity.setLastname(memberDTO.getLastname());
        memberEntity.setDni(memberDTO.getDni());
        memberEntity.setEmail(memberDTO.getEmail());
        memberEntity.setBirthdate(memberDTO.getBirthdate());
        return memberEntity;
    }
}
