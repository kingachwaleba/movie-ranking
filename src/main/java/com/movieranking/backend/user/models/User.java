package com.movieranking.backend.user.models;

import com.movieranking.backend.role.models.Role;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false, length = 20)
    @Size(min = 5, max = 20)
    @NotBlank(message = "Login is mandatory!")
    private String login;

    @Column(unique = true, nullable = false, length = 20)
    @Size(min = 5, max = 20)
    @NotBlank(message = "Email is mandatory!")
    private String email;

    @ManyToMany
    private Set<Role> role;

    @Column(nullable = false)
    @Size(min = 5, max = 20)
    @NotBlank(message = "password is mandatory!")
    private String password;

    @Transient
    private String passwordConfirm;

    @Column(length = 100)
    @Size(min = 5, max = 100)
    private String specialNotes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialNotes() {
        return specialNotes;
    }

    public void setSpecialNotes(String specialNotes) {
        this.specialNotes = specialNotes;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
