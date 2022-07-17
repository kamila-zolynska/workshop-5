package pl.coderslab.controller;

import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.MockBookService;

import java.util.List;


@RestController
@RequestMapping("/books")
@Data
public class BookController {

    private final MockBookService mockBookService;

    @GetMapping
    public List<Book> allBooks() {
        return mockBookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book bookById(@PathVariable Long id) {
        return mockBookService.getBookById(id);
    }

    @PostMapping()
    public String addBook(@RequestBody Book book) {
        mockBookService.addBookToList(book);
        return "Ksiazka zostala dodana.";
    }

    @PutMapping()
    public String modifyBook(@RequestBody Book book) {
        mockBookService.modifyBook(book);
        return "Ksiazka zostala zmodyfikowana";
    }

    @DeleteMapping("/{id}")
    public String removeBookById(@PathVariable Long id) {
        mockBookService.removeBookById(id);
        return "Ksiazka zostala usunieta.";
    }
}
