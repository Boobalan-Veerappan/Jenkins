package com.allinone.AllInOne.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.annotation.Nonnull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserWithBooks {


    public Long id;

    public String name;

    public String emailId;
    public List<BookDto> bookDetails;

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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public List<BookDto> getBookDetails() {
        return bookDetails;
    }

    @Override
    public String toString() {
        return "UserWithBooks{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", bookDetails=" + bookDetails +
                '}';
    }

    public void setBookDetails(List<BookDto> bookDetails) {
        this.bookDetails = bookDetails;
    }

}
