package Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindBookById() {
        Book book = new Book("1", "Test Book", "Test Author");
        when(bookRepository.findById("1")).thenReturn(book);

        Book result = bookService.findBookById("1");

        assertEquals(book, result);
        verify(bookRepository).findById("1");
    }

    @Test
    public void testFindAllBooks() {
        List<Book> books = Arrays.asList(
            new Book("1", "Test Book 1", "Test Author 1"),
            new Book("2", "Test Book 2", "Test Author 2")
        );
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> result = bookService.findAllBooks();

        assertEquals(books, result);
        verify(bookRepository).findAll();
    }
}