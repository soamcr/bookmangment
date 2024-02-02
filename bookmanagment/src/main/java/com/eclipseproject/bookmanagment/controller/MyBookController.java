package com.eclipseproject.bookmanagment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eclipseproject.bookmanagment.entity.Book;
import com.eclipseproject.bookmanagment.service.MyBookService;

@Controller
public class MyBookController {

	@Autowired
	private MyBookService mbService;
	
	@RequestMapping("/delete/{id}")
	public String delMyBook(@PathVariable("id") int id) {
		mbService.delById(id);
		return "redirect:/myBooks";
	}
}
