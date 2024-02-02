package com.eclipseproject.bookmanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eclipseproject.bookmanagment.entity.MyBooks;


@Repository
public interface MyBookRepository extends JpaRepository<MyBooks, Integer> {

}
