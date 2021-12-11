package com.greatlearning.lmsvideo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class BooksController {
	@Autowired
	private BookService bookService;
	
	@RequestMapping( "/list" ) // /books/list
	public String listBooks( Model model ) {
		List<Book> books = bookService.findAll();
		
		model.addAttribute( "books", books );
		
		return "list-books";
	}
	
	@RequestMapping("/new")
	public String showFormForAdd( Model model ) {
		Book book = new Book();
		
		model.addAttribute( "newBook", true );
		model.addAttribute( "book", book );
		
		return "edit-book";
	}
	
	@RequestMapping("/edit")
	public String showFormForEdit(
		@RequestParam("id") int id,
		Model model
	) {
		Book book = bookService.findById( id );
		
		model.addAttribute( "newBook", false );
		model.addAttribute( "book", book );
		
		return "edit-book";
	}
	
	@PostMapping("/save")
	public String saveBook(
		@RequestParam("id") int id,
		@RequestParam("name") String name,
		@RequestParam("category") String category,
		@RequestParam("author") String author
	) {
		Book book = null;
		
		if( id == 0 ) {
			book = new Book( name, category, author );
		} else {
			book = bookService.findById( id );
			book.setName( name );
			book.setCategory( category );
			book.setAuthor( author ); 
		}
		
		System.out.println( book );
		
		bookService.save( book );
				
		return "redirect:/books/list";
	}
	
	@RequestMapping("/delete")
	public String showFormForAdd( @RequestParam("id") int id ) {
		bookService.deleteById( id );
		
		return "redirect:/books/list";
	}
}
