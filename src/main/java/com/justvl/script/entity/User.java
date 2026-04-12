package com.justvl.script.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;

@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @JdbcTypeCode(Types.LONGNVARCHAR)
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @NonNull
    @Column(name = "password", unique = true, nullable = false)
    private String password;
}
