package com.allinone.AllInOne.Domain;

import com.allinone.AllInOne.Dto.UserWithBooks;
import jakarta.persistence.*;
import lombok.Builder;

import javax.annotation.MatchesPattern;

@Entity
@Table(name="USERDETAILS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    @MatchesPattern("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
    public String email;

    public User(){
        super();

    }
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static User newUser(UserWithBooks userDetails){
        return new User(userDetails.getName(),userDetails.getEmailId());
    }


}
