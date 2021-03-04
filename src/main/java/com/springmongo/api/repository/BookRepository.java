package com.springmongo.api.repository;


import com.springmongo.api.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,Integer> {

}
