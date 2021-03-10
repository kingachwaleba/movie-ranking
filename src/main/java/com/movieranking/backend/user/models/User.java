package com.movieranking.backend.user.models;

import com.movieranking.backend.gender.models.Gender;
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

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @ManyToMany
    private Set<Role> roles;

    @Column(length = 100)
    @Size(min = 5, max = 100)
    private String specialNotes;

    public User() {
    }

    public User(@Size(min = 5, max = 20) @NotBlank(message = "Login is mandatory!") String login,
                @Size(min = 5, max = 20) @NotBlank(message = "Email is mandatory!") String email, Gender gender) {
        this.login = login;
        this.email = email;
        this.gender = gender;
    }

    public User(@Size(min = 5, max = 20) @NotBlank(message = "Login is mandatory!") String login,
                @Size(min = 5, max = 20) @NotBlank(message = "Email is mandatory!") String email, Gender gender,
                @Size(min = 5, max = 100) String specialNotes) {
        this.login = login;
        this.email = email;
        this.gender = gender;
        this.specialNotes = specialNotes;
    }

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getSpecialNotes() {
        return specialNotes;
    }

    public void setSpecialNotes(String specialNotes) {
        this.specialNotes = specialNotes;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
