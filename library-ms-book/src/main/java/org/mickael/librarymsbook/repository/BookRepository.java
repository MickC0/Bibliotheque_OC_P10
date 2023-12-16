package org.mickael.librarymsbook.repository;

import org.mickael.librarymsbook.model.Book;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {


    List< Book > getBooksByTitleContains(String title);
    List< Book > findAllByTitleContains(String title);

    @Query("SELECT book FROM Book book WHERE (:title = '' OR LOWER(book.title) LIKE LOWER(:title))")
    List< Book > findBookBySearchTitle(@Param( "title" ) String title, Sort sort);


    @Query(value = "SELECT book FROM Book book " +
                   "JOIN book.author author " +
                   "WHERE ((:author = '' OR LOWER(author.firstName) LIKE LOWER(:author))" +
                   "OR (:author = '' OR LOWER(author.lastName) LIKE LOWER(:author)))")
    List< Book > findBySearchAuthor(@Param("author") String author);


}
