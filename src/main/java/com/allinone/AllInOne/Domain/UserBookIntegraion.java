package com.allinone.AllInOne.Domain;

import com.allinone.AllInOne.Domain.UserBookId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@IdClass(UserBookId.class)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_BOOK_INTEGRATION")
public class UserBookIntegraion {

    @Id
    Long userId;

    @Id
    Long bookId;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBooId() {
        return bookId;
    }

    public void setBooId(Long booId) {
        this.bookId = booId;
    }
}
