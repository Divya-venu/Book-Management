package com.book.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.book.entity.Book;
import com.book.service.BookService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins="*")
public class BookController {
	
	@Autowired
	private BookService bs;
	
	//CREATE
	@PostMapping("/add")
	public String addBook(@RequestBody Book book) {
		return bs.insertBook(book);
	}
	
	//READ ALL
	@GetMapping("/all")
	public List<Book> getAllBooks() {
	    return bs.getAllBooks();
	}
	
	//UPDATE
	@PutMapping("update/{id}")
	public String updateBook(@PathVariable Integer id, @RequestBody Book book) {
		return bs.updateBook(id, book);
	}
	
	//Delete
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable Integer id) {
		return bs.deleteBook(id);
	}
}