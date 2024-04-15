package com.library.libraryService.model;

import lombok.Data;
@Data
public class MemberDTO {
    private String id;
    private String name;
    private String lastname;
    private String dni;
    private String email;
    private String birthdate;
}
