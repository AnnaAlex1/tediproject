package com.devproject.tediproject.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    @NotNull
    private String username;
    @NotNull private String password;

    @OneToOne
    private Professional professional;

    @OneToOne
    private Admin admin;


    public User() { }

    public User(String username, String password, Professional professional) {
        this.username = username;
        this.password = password;
        this.professional = professional;
        this.admin = null;
    }

    public User(String username, String password, Admin admin) {
        this.username = username;
        this.password = password;
        this.professional = null;
        this.admin = admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
