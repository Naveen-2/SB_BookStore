package com.bridgelabz.bookstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bridgelabz.bookstore.model.BookData;

@Repository
public interface BookRepository extends JpaRepository<BookData, Integer>{
	
	Optional<BookData>  findByBookID(int bookID);

    Optional<Object> findByBookName(String bookName);
    
    @Query(value = "SELECT * FROM books order by price ASC", nativeQuery = true)
    List<BookData> sortBookAsc();
    
    @Query(value = "SELECT * FROM books order by price DESC ", nativeQuery = true)
    List<BookData> sortBookDesc();
    
}
