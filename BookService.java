package com.book.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Book;
import com.book.repository.BookRepository;
@Service
public class BookService {
	
	@Autowired
	BookRepository br;
	
	public List<Book> getAllBooks(){
		return (List<Book>)br.findAll();
	}
	
	public Optional getBook(Integer bid) {
		return br.findById(bid);
	}
	
	public String insertBook(Book b) {
		br.save(b);
		return "Book Saved Sucessfully";
	}
	
	public String updateBook(int bid, Book b) {
	    if (br.existsById(bid)) {
	        br.save(b);
	        return "Book Updated Successfully";
	    }
	    return "Book not found";
	    }
	
	public String deleteBook(Integer bid) {
	    br.deleteById(bid);
	    return "Book deleted successfully";
	}
}
