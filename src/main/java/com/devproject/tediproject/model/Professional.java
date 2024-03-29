package com.devproject.tediproject.model;

import com.devproject.tediproject.payload.ProfessionalAddRequest;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Professional {

    @Id @GeneratedValue private Long id;
    @Column(unique = true)
    @NotNull private String username;
    @NotNull private String password;
    @NotNull private String name;
    @NotNull private String surname;
    @Column(unique = true)
    @NotNull private String email;
    private String phone;
    private String picture_url;
    @NotNull private Boolean name_surname_public;
    @NotNull private Boolean email_public;
    @NotNull private Boolean phone_public;
    private String work_position;
    private String work_place;



    @JsonManagedReference(value="prof-not")
    @OneToMany(cascade = CascadeType.ALL)
    List<Notification> userNotifications;


//    @OneToMany
//    private List<Education> educationList;
//
//    @OneToMany
//    private List<Experience> experienceList;
//
//    @JsonManagedReference(value="prof-mes")
//    @OneToMany(targetEntity = Message.class, cascade = CascadeType.ALL)
//    private List<Message> messageList;
//
//    @JsonManagedReference(value="prof-conv")
//    @OneToMany(targetEntity = Conversations.class, cascade = CascadeType.ALL)
//    private List<Conversations> conversationsList;


    @JsonManagedReference(value="prof-post")
    @OneToMany(targetEntity = Post.class, cascade = CascadeType.ALL)
    private List<Post> postList;

    @ManyToMany
    private List<JobPosting> applications;



    public Professional() {}

    public Professional(ProfessionalAddRequest prof) {
        this.username = prof.getUsername();
        this.password = prof.getPassword();
        this.name = prof.getName();
        this.surname = prof.getSurname();
        this.email = prof.getEmail();
        this.phone = prof.getPhone();
        this.picture_url = prof.getPicture_url();
        if (this.picture_url == null) this.picture_url = "https://www.pngitem.com/pimgs/m/150-1503945_transparent-user-png-default-user-image-png-png.png";
        this.name_surname_public = true;
        this.email_public = true;
        this.phone_public = true;
        this.work_position = null;
        this.work_place = null;
//        this.messageList = null;
        this.postList = null;
        this.applications = null;
        this.userNotifications = null;
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

    public void setEmail(String email) { this.email = email; }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPicture_url() { return picture_url; }

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

    public List<Notification> getUserNotifications() {
        return userNotifications;
    }

    public void setUserNotifications(List<Notification> userNotifications) {
        this.userNotifications = userNotifications;
    }

    //
//    public List<Education> getEducationList() {
//        return educationList;
//    }
//
//    public void setEducationList(List<Education> educationList) {
//        this.educationList = educationList;
//    }
//
//    public List<Experience> getExperienceList() {
//        return experienceList;
//    }
//
//    public void setExperienceList(List<Experience> experienceList) {
//        this.experienceList = experienceList;
//    }

//    public List<Message> getMessageList() {
//        return messageList;
//    }
//
//    public void setMessageList(List<Message> messageList) {
//        this.messageList = messageList;
//    }


    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public String getWork_position() { return work_position; }

    public void setWork_position(String work_position) { this.work_position = work_position;  }

    public String getWork_place() { return work_place; }

    public void setWork_place(String work_place) { this.work_place = work_place; }

    public List<JobPosting> getApplications() {
        return applications;
    }

    public void setApplications(List<JobPosting> applications) {
        this.applications = applications;
    }

    //ADDS
    public void addNewPost( Post post ) { this.postList.add(post); }

    public void addNewApplication( JobPosting jobPosting ) { this.applications.add(jobPosting); }

    public void removePost(Post post) { this.postList.remove(post);}


}
