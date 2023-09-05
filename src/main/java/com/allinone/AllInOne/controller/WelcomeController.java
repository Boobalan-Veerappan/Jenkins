package com.allinone.AllInOne.controller;

import com.allinone.AllInOne.Domain.Book;
import com.allinone.AllInOne.Domain.User;
import com.allinone.AllInOne.Dto.BookDto;
import com.allinone.AllInOne.Dto.UserWithBooks;
import com.allinone.AllInOne.Respository.BookRespo;
import com.allinone.AllInOne.Respository.UserDetilsRepo;
import com.allinone.AllInOne.mapping.AllInOneMapping;
import com.allinone.AllInOne.service.AllInOneService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class WelcomeController {

    @Autowired
    BookRespo bookrespo;

    @NonNull
    AllInOneMapping allinMapping;

    @NonNull
    UserDetilsRepo userRepo;

    @NonNull AllInOneService allinOneService;


    @GetMapping("/world")
    public String getResponse(){

        return "Hello World";
    }

    @PostMapping("/save")
    public Book saveRequest(@RequestBody Book book){
       return bookrespo.save(book);
    }

    @GetMapping("/books")
    public List<Book> getBook(){
        return bookrespo.findAll();
    }

    @PostMapping("/addUser")
    public List<Book> addUserDetails(@RequestBody  UserWithBooks userDetails){
        System.out.println(userDetails.toString());
        return allinOneService.getBookDetails(userDetails);
    }

}
