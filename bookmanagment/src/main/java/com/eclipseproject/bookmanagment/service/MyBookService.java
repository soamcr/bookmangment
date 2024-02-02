package com.eclipseproject.bookmanagment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eclipseproject.bookmanagment.entity.Book;
import com.eclipseproject.bookmanagment.entity.MyBooks;
import com.eclipseproject.bookmanagment.repository.MyBookRepository;

@Service
public class MyBookService {
	@Autowired
	MyBookRepository mbookRepo;
	
	public void myBookSave(MyBooks myBook) {
		
		mbookRepo.save(myBook);
		
	}
	public List<MyBooks> myBookfindAll() {
		return mbookRepo.findAll();
	}
	
	public void delById(int id) {
		 mbookRepo.deleteById(id);
	}
	
}
