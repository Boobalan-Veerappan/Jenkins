package com.allinone.AllInOne.service;

import com.allinone.AllInOne.Domain.Book;
import com.allinone.AllInOne.Domain.User;
import com.allinone.AllInOne.Dto.BookDto;
import com.allinone.AllInOne.Dto.UserWithBooks;
import com.allinone.AllInOne.Respository.BookRespo;
import com.allinone.AllInOne.Respository.UserBookIntegrationRepo;
import com.allinone.AllInOne.Respository.UserDetilsRepo;
import com.allinone.AllInOne.mapping.AllInOneMapping;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {


    AllInOneService allinOneServicetest;

    @Mock
    AllInOneMapping allinOneMappingTest;

    @Mock
    UserDetilsRepo userRepoTest;

    @Mock
    UserBookIntegrationRepo userBookIntegrationTest;

    @Mock
    BookRespo bookRepoTest;


    @Before
    public void setup() {
        allinOneServicetest = new AllInOneService(bookRepoTest, allinOneMappingTest
                , userRepoTest, userBookIntegrationTest);
    }

    @Test
    public void getDetailBookTest() {
        User saveUser = User.newUser(UserWithBooks.builder().emailId("raghul@gmail.com").name("Raghul").build());
        saveUser.id = (long)100;
        List<Book> allBookUser = Arrays.asList(Book.builder().id((long) 1).name("Great Book").description(" Great Book is Great").author(" Boobalan is the great author ").build(),Book.builder().id((long) 2).name("Great Book II ").description(" Great Book is Great").author(" Boobalan is the great author With Great Knowledge").build());
        UserWithBooks userDetails = UserWithBooks.builder().id(Long.valueOf(1)).emailId("boobalan@gmail.com").name("Boobalan").bookDetails(Arrays.asList(BookDto.builder().name("Good Will").author("Indian Author").description("This Book to understand the Basic Thing").build())).build();
        UserWithBooks userDetailsTwo = UserWithBooks.builder().id(Long.valueOf(123)).emailId("raghulkpm@gmail.com").name("Raghul").bookDetails(Arrays.asList(BookDto.builder().name("Bad Will").author("Foregin Author").description("This Book to understand the Depth Thing").build())).build();
        when(allinOneMappingTest.fromBookDtoToBook(userDetails)).thenReturn(allBookUser);
        when(bookRepoTest.saveAll(allBookUser)).thenReturn(allBookUser);
        when(allinOneMappingTest.fromUserBookToUser(userDetails)).thenReturn(saveUser);
        when(userRepoTest.save(saveUser)).thenReturn(saveUser);

        assertThat(allinOneServicetest.getBookDetails(userDetails).size()).isEqualTo(2);

    }

}
