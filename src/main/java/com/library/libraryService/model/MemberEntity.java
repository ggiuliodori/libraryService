package com.library.libraryService.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "members")
@Data
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String lastname;
    private String dni;
    private String email;
    private String birthdate;
}
