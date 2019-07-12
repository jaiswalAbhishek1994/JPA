package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.jpa.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
