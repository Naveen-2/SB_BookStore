package com.bridgelabz.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bridgelabz.bookstore.model.BookData;

@Repository
public interface BookRepository extends JpaRepository<BookData, Integer>{
	
	@Query(value = "SELECT * FROM book_table order by book_name ASC", nativeQuery = true)
    List<BookData> sortBookAscendingOrder();

    @Query(value = "SELECT * FROM book_table order by book_name DESC", nativeQuery = true)
    List<BookData> sortBookDescendingOrder();
    
    List<BookData> findBookDataByBookAuthor(String bookAuthor);
    
}
