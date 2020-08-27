package com.fastcampus.faststore.service;

import com.fastcampus.faststore.entity.Book;
import com.fastcampus.faststore.repository.BookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;


@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookRepository bookRepository;

    private BookService bookService;

    @BeforeEach
    public void setup() {
        bookService = new BookService(bookRepository);
    }

    @AfterEach
    public void tearDown() {
        bookRepository.deleteAll();
    }

    // TODO: getOrThrow 테스트 코드를 작성하세요.
    @Test()
    public void getOrThrow() {
        Book book = new Book("자바","이승준", 1000L);
        bookRepository.save(book);
        assertThat(bookService.getOrThrow("자바").getTitle()).isEqualTo(book.getTitle());
        assertThat(bookService.getOrThrow("자바").getAuthor()).isEqualTo(book.getAuthor());
        assertThat(bookService.getOrThrow("자바").getPrice()).isEqualTo(book.getPrice());
        RuntimeException exception =
                assertThrows(RuntimeException.class,() -> bookService.getOrThrow("이상한 이름"));
        String message = exception.getMessage();
        assertThat(message).isEqualTo("해당 제목의 책이 존재하지 않습니다.");

    }

    @Test
    public void registerBook() {
        bookService.registerBook("자바의 정석", "남궁성", 3000L);

        assertThat(bookRepository.findByTitle("자바의 정석")).isNotNull();
    }
}
