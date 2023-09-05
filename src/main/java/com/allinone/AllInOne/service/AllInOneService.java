package com.allinone.AllInOne.service;

import com.allinone.AllInOne.Domain.Book;
import com.allinone.AllInOne.Domain.User;
import com.allinone.AllInOne.Domain.UserBookIntegraion;
import com.allinone.AllInOne.Dto.UserWithBooks;
import com.allinone.AllInOne.Respository.BookRespo;
import com.allinone.AllInOne.Respository.UserBookIntegrationRepo;
import com.allinone.AllInOne.Respository.UserDetilsRepo;
import com.allinone.AllInOne.mapping.AllInOneMapping;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AllInOneService {

    @NonNull BookRespo bookRepo;

    @NonNull AllInOneMapping allinMapping;

    @NonNull UserDetilsRepo userDetilsRepo;

    @NonNull
    UserBookIntegrationRepo userIntegrationRepo;

    public List<Book> getBookDetails(UserWithBooks userDetail){
       List<Book> bookDetails=  allinMapping.fromBookDtoToBook(userDetail);
        List<Book> newBookDetails =  bookRepo.saveAll(bookDetails);
        User newUser = userDetilsRepo.save(allinMapping.fromUserBookToUser(userDetail));
        saveIntegrationWithUserAndBook(newUser.id,newBookDetails);
        return newBookDetails;
    }

    public void saveIntegrationWithUserAndBook(Long id,List<Book> newBookDetails){
        newBookDetails.stream().forEach(data->{
            userIntegrationRepo.save(new UserBookIntegraion(id,data.id));
        });
    }
}
