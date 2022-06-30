package com.neliyenn.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "post")
public class Post {

    private Long id;
    @Length(min = 5, message = "*Tytuł musi mieć conajmniej 5 znaków")
    @NotEmpty(message = "*Wpisz tytuł")
    private String title;
    private String body;
    private Date createDate;
    @NotNull
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "body", columnDefinition = "TEXT")
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false, updatable = false)
    @CreationTimestamp
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date date) {
        this.createDate = date;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
