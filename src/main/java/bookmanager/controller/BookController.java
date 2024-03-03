package bookmanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import bookmanager.*;
import bookmanager.dto.BookCreateOrUpdateRequest;
import bookmanager.dto.BookIdResponse;
import bookmanager.dto.BookListResponse;

import java.util.Optional;

@RestController
public class BookController {

    @PostMapping("/book")
    public BookIdResponse createTask(@RequestBody BookCreateOrUpdateRequest request) {
        Book book = new Book(request.getName(), request.getYear());
        int id = BookStorage.addBook(book);
        return new BookIdResponse(id);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<UnidentifiedBook> getBook(@PathVariable Integer id) {
        Optional<UnidentifiedBook> book = BookStorage.getBook(id);
        return book.isPresent() ?
                new ResponseEntity<>(book.get(), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/book")
    public BookListResponse getTaskList() {
        return new BookListResponse(BookStorage.getBookList());
    }

    @DeleteMapping("/book/{id}")
    public void deleteTask(@PathVariable Integer id) {
        BookStorage.deleteBook(id);
    }

    @PutMapping("/book/{id}")
    public void updateTask(@PathVariable Integer id, @RequestBody BookCreateOrUpdateRequest request) {
        Book book = new Book(request.getName(), request.getYear());
        BookStorage.updateBook(id, book);
    }
}
