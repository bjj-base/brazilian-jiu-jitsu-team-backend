package com.example.videos.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "app_user", indexes = {
        @Index(columnList = "id", name = "user_id_index")
})
@SequenceGenerator(name = "SEQ_STORE", sequenceName = "user_id_seq", allocationSize = 1)
@Data
public class AppUser extends BaseModel {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public AppUser() {
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
