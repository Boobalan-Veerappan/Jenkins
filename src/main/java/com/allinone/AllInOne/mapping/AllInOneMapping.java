package com.allinone.AllInOne.mapping;

import com.allinone.AllInOne.Domain.Book;
import com.allinone.AllInOne.Domain.User;
import com.allinone.AllInOne.Dto.BookDto;
import com.allinone.AllInOne.Dto.UserWithBooks;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.springframework.stereotype.Component;
import lombok.*;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AllInOneMapping {

    public User fromUserBookToUser(UserWithBooks userDetails){
        return User.newUser(userDetails);
    }

    public List<Book> fromBookDtoToBook(UserWithBooks userWithBooks){
        return userWithBooks.getBookDetails().stream().map(AllInOneMapping::fromBookDtoBook).collect(Collectors.toList());
    }

    static Book fromBookDtoBook(BookDto bookDto){

        return Book.builder().author(bookDto.getAuthor())
                .description(bookDto.getDescription())
                .name(bookDto.name)
                .build();
    }

}
