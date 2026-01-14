package com.bookstore.jpa.services;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bookstore.jpa.dtos.BookRecordDto;
import com.bookstore.jpa.models.BookModel;
import com.bookstore.jpa.models.ReviewModel;
import com.bookstore.jpa.repositories.AuthorRepository;
import com.bookstore.jpa.repositories.BookRepository;
import com.bookstore.jpa.repositories.PublisherRepository;

import jakarta.transaction.Transactional;

@Service
public class BookServices {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public BookServices(BookRepository bookRepository, AuthorRepository authorRepository,
            PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Transactional
    public BookModel saveBook(BookRecordDto bookRecordDto){
        BookModel book = new BookModel();
        book.setTitle(bookRecordDto.title());
        book.setPublisher(publisherRepository.findById(bookRecordDto.publisherid()).get());
        book.setAuthors(authorRepository.findAllById(bookRecordDto.authorsIds()).stream().collect(Collectors.toSet()));

        ReviewModel reviewModel = new ReviewModel();
        reviewModel.setComment(bookRecordDto.reviewsComment());
        reviewModel.setBook(book);
        book.setReview(reviewModel);

        return bookRepository.save(book);
    }

    public BookModel findById(UUID id){
        return bookRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Book not found"));
    }

    public List<BookModel> findAll(){
        return bookRepository.findAll();
    }

    public BookModel findByTitle(String title) {
        return bookRepository.findBookModelByTitleContainingIgnoreCase(title);
    }

    @Transactional
    public BookModel updateBook(UUID id, BookRecordDto bookRecordDto){
        BookModel book = bookRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Book not found"));

        book.setTitle(bookRecordDto.title());
        book.setPublisher(
            publisherRepository.findById(bookRecordDto.publisherid()).orElseThrow(() -> new RuntimeException("Publisher not found")));       
            
        book.setAuthors(authorRepository.findAllById(bookRecordDto.authorsIds()).stream().collect(Collectors.toSet()));
        
        return bookRepository.save(book);

    }

    @Transactional
    public void deleteById(UUID id){
        if(!bookRepository.existsById(id)){
            throw new RuntimeException("Book not found");
        }

        bookRepository.deleteById(id);
    }
}   
