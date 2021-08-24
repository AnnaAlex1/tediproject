package com.devproject.tediproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Professional {

    @Id @GeneratedValue private Long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private Long phone;
    private String picture_url;
    private Boolean name_surname_public;
    private Boolean email_public;
    private Boolean phone_public;


    @OneToMany(targetEntity = Message.class)
    private List<Message> messageList;

    @OneToMany(targetEntity = Post.class)
    private List<Post> postList;



    public Professional() {}
    public Professional(Long id, String username, String password, String name, String surname, String email, Long phone, String picture_url, Boolean name_surname_public, Boolean email_public, Boolean phone_public) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.picture_url = picture_url;
        this.name_surname_public = name_surname_public;
        this.email_public = email_public;
        this.phone_public = phone_public;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public Boolean getName_surname_public() {
        return name_surname_public;
    }

    public void setName_surname_public(Boolean name_surname_public) {
        this.name_surname_public = name_surname_public;
    }

    public Boolean getEmail_public() {
        return email_public;
    }

    public void setEmail_public(Boolean email_public) {
        this.email_public = email_public;
    }

    public Boolean getPhone_public() {
        return phone_public;
    }

    public void setPhone_public(Boolean phone_public) {
        this.phone_public = phone_public;
    }


}
