package com.springmongo.api.resource;

import com.springmongo.api.BookService;
import com.springmongo.api.model.Book;
import com.springmongo.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;
    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }
    @GetMapping("/findAllBooks")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/findBookById")
    public Optional<Book> getBook(@RequestParam int id){
        return bookService.getBook(id);
    }

    @PostMapping("/updateBook")
    public Book updateBook(@RequestBody Book bookReq) {
        return bookService.updateBook(bookReq);
    }

    @DeleteMapping("/delete")
    public String deleteBook(@RequestParam int id){
        return bookService.deleteBook(id);
    }
}
