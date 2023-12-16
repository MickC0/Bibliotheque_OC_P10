package org.mickael.librarymsbook.repository;

import org.mickael.librarymsbook.model.Copy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CopyRepository extends JpaRepository<Copy, Integer> {

    @Query(value = "SELECT copy FROM Copy copy " +
                           "JOIN copy.book book " +
                           "WHERE (:title = '' OR LOWER(book.title) LIKE LOWER(:title))" +
                           "AND (:available = false OR copy.available = :available)")
    List<Copy> findByTitleSearchValue (@Param("title") String title, @Param("available") boolean available);

    @Query(value = "SELECT copy FROM Copy copy " +
                           "JOIN copy.book book " +
                           "JOIN book.author author " +
                           "WHERE ((:author = '' OR LOWER(author.firstName) LIKE LOWER(:author))" +
                           "OR (:author = '' OR LOWER(author.lastName) LIKE LOWER(:author)))" +
                           "AND (:available = false OR copy.available = :available)")
    List<Copy> findByAuthorSearchValue (@Param("author") String author, @Param("available") boolean available);

    @Query(value = "SELECT distinct copy FROM Copy copy WHERE copy.available = :available")
    List<Copy> findAllByAvailable(@Param("available") boolean available);

    @Query(value = "SELECT copy FROM Copy copy jOIN copy.book book WHERE (copy.available = true) AND (book.id = :id)")
    List<Copy> findAllCopyAvailableForOneBook(@Param("id") Integer id);

    @Query(value = "SELECT copy FROM Copy copy jOIN copy.book book WHERE book.id = :id")
    List<Copy> findAllCopyForOneBook(@Param("id") Integer id);

    @Query(value = "select count (copy) from Copy copy where copy.available=true and copy.book.id = :bookId")
    Integer findAllCopiesAvailabeForOneBook(@Param("bookId") Integer bookId);

    @Query(value = "select count (copy) from Copy copy where copy.book.id = :bookId")
    Integer findAllCopiesForOneBook(@Param("bookId") Integer bookId);

}
