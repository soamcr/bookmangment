package com.eclipseproject.bookmanagment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eclipseproject.bookmanagment.entity.Book;
import com.eclipseproject.bookmanagment.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bRepo;
	
	public void save(Book b) {
		bRepo.save(b);
		
	}
	public List<Book> findAll() {
		return bRepo.findAll();
	}
	public Book getBook(int id) {
		return bRepo.findById(id).get();
	}
	public void delBook(int id) {
		 bRepo.deleteById(id);
	}
}
