package com.justvl.script.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "name", nullable = false)
    private String name;

    @NonNull
    @Setter
    @Column(name = "author", nullable = false, columnDefinition = "varchar(255) default 'Anonymous'")
    private String author = "Anonymous";

    @NonNull
    @Column(name = "description", nullable = false)
    private String description;
}
