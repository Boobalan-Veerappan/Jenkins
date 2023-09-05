package com.allinone.AllInOne.Domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class UserBookId implements Serializable {
    static final long serialVersionUID = 620000L;
    Long userId;
    Long bookId;

}
