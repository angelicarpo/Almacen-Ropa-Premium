package com.papeleria.soho.papeleriasoho.models;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "Roles")
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private ERole name;

}
