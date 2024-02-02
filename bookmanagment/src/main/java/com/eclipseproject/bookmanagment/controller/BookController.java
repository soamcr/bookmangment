package com.eclipseproject.bookmanagment.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.eclipseproject.bookmanagment.entity.Book;
import com.eclipseproject.bookmanagment.entity.MyBooks;
import com.eclipseproject.bookmanagment.service.BookService;
import com.eclipseproject.bookmanagment.service.MyBookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookService mbService;
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	@GetMapping("/book_available")
	public ModelAndView bookAvailable() {
		List<Book> list=service.findAll();
		return new ModelAndView("bookAvailable","book",list);
	}
	@GetMapping("/myBooks")
	public ModelAndView myBooks() {
		List<MyBooks> list=mbService.myBookfindAll();
		return new ModelAndView("myBooks","mb",list);
	}
	@PostMapping("/save")
	public String addBooks(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/book_available";
	}
	@GetMapping("/list/{id}")
	public String listMyBooks(@PathVariable("id") int id) {
		Book b=service.getBook(id);
		MyBooks mb=new MyBooks(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
		mbService.myBookSave(mb);
		
		return "redirect:/book_available";
	} 
	@GetMapping("/editBook/{id}")
	public String editMyBooks(@PathVariable("id") int id,Model model) {
		
		Book b=service.getBook(id);
		model.addAttribute("book",b);
		return "edit";
	} 
	@GetMapping("/deleteBook/{id}")
	public String delMyBooks(@PathVariable("id") int id) {
		
		Book b=service.getBook(id);
		service.delBook(id);
		return "redirect:/book_available";
	} 
}
	