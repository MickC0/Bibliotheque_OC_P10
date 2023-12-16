package org.mickael.librarymsbook.service.impl;

import org.mickael.librarymsbook.exception.BookNotFoundException;
import org.mickael.librarymsbook.model.Book;
import org.mickael.librarymsbook.repository.BookRepository;
import org.mickael.librarymsbook.service.contract.BookServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookServiceContract {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() throws BookNotFoundException {
        List<Book> books = bookRepository.findAll(Sort.by("title"));
        if (books.isEmpty()){
            throw new BookNotFoundException("No book found");
        }
        return books;
    }

    @Override
    public Book findById(Integer id) throws BookNotFoundException {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (!optionalBook.isPresent()){
            throw new BookNotFoundException("Book not found in repository");
        }
        return optionalBook.get();
    }

    @Override
    public Book save(Book book) {

        Book savedBook =  bookRepository.save(book);

        return savedBook;
    }

    @Override
    public Book update(Book book) throws BookNotFoundException{
        Optional<Book> optionalBook = bookRepository.findById(book.getId());
        if (!optionalBook.isPresent()){
            throw new BookNotFoundException("Book not found in repository");
        }
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findBookBySearchParameter(String criteria, String searchValue) throws BookNotFoundException{
        List<Book> bookList = new ArrayList<>();
        searchValue = "%" + searchValue + "%";
        if (criteria.equalsIgnoreCase("author")){
            bookList = bookRepository.findBySearchAuthor(searchValue);
        }
        if (criteria.equalsIgnoreCase("title")){
            bookList = bookRepository.findBookBySearchTitle(searchValue, Sort.by("title"));
        }
        if (bookList.isEmpty()){
            throw new BookNotFoundException("No book with this " + criteria);
        }
        return bookList;
    }
}
