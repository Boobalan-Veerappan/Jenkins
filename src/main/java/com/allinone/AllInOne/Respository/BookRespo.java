package com.allinone.AllInOne.Respository;

import com.allinone.AllInOne.Domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRespo extends JpaRepository<Book,Long> {

    Book save(Book b);

}
