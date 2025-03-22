package com.website.loveconnect.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "interests")
@Getter
@Setter
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interest_id")
    private Long interestId;

    @Column(name = "interest_name", nullable = false, unique = true)
    private String interestName;

    @Column(name = "category")
    private String category;

    @ManyToMany(mappedBy = "interests")
    private Set<User> users;
}
