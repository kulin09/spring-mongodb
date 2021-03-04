package com.springmongo.api;

import com.springmongo.api.model.Book;
import com.springmongo.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public String saveBook(Book book){
        repository.save(book);
        return "Added book with id: "+book.getId();
    }

    public List<Book> getBooks(){
        return repository.findAll();
    }

    public Optional<Book> getBook(int id){
        return repository.findById(id);
    }
    public Book updateBook(Book bookReq) {
        Optional<Book> book = repository.findById(bookReq.getId());
        book.ifPresent(elem -> {
            elem.setBookName(bookReq.getBookName());
            elem.setAuthorName(bookReq.getAuthorName());
            repository.save(elem);
        });
        return book.orElse(null);
    }

    public String deleteBook(int id){
        repository.deleteById(id);
        return "Book deleted with id: "+ id;
    }
}
