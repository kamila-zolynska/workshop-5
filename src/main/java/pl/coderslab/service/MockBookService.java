package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MockBookService {
    private static List<Book> books = List.of(
            new Book(1L, "9788324631766", "Thinking in Java",
                    "Bruce Eckel", "Helion", "programming"),
            new Book(2L, "4848484665565", "Nawyki warte miliony. ",
                    "Brian Tracy", "Onpress", "psychology")
    );
    private static Long nextBookId = 3L;

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(Long id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public void addBookToList(Book book) {
        book.setId(nextBookId);
        books.add(book);
        nextBookId++;
    }

    public void modifyBook(Book book) {
        Book bookToModify = getBookById(book.getId());
        bookToModify.setIsbn(book.getIsbn());
        bookToModify.setTitle(book.getTitle());
        bookToModify.setAuthor(book.getAuthor());
        bookToModify.setPublisher(book.getPublisher());
        bookToModify.setType(book.getType());
    }

    public void removeBookById(Long id) {
        Book bookToDelete = getBookById(id);
        books.remove(bookToDelete);
    }
}
