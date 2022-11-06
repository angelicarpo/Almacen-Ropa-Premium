package com.papeleria.soho.papeleriasoho.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = {
    @UniqueConstraint(columnNames = "username"),
    @UniqueConstraint(columnNames = "email")
})
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @NotBlank(message = "UserName es requerido")
    @Size(max = 20)
    @Column(length = 20, nullable = false)
    private String username;

    @NotBlank(message = "Password es requerido")
    @Size(max = 120)
    @Column(length = 120, nullable = false)
    private String password;

    @NotBlank(message = "Email es requerido")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    
    public User(String username, String email, String password) {
      this.username = username;
      this.email = email;
      this.password = password;
    }
}
