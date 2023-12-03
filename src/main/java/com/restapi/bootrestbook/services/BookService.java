package com.restapi.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.restapi.bootrestbook.entities.Book;
@Component
public class BookService {
	
	private static List<Book> list=new ArrayList<>();
	
	static{
		
		list.add(new Book(2,"Java Complete Rerence","ABCX"));
		list.add(new Book(3,"Python Complete Rerence","WABCGX"));
		list.add(new Book(4,"C++ Complete Rerence","SEWEABCX"));
		list.add(new Book(5,"React Complete Rerence","RASBCX"));
	}
	
public List<Book> getAllBooks()
{
	return list;
}

public Book getBookById(int id)
{
	Book book=null;
	list.stream().filter(e->e.getId()==id).findFirst().get();
	return book;
}
public Book addBook(Book b)
{
	list.add(b);
	return b;
}

public void deleteBook(int bid)
{
	list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
	
}

public void updateBook(Book book,int bookId)
{
	list =list.stream().map(b->{
		if(b.getId()==bookId)
		{
			b.setTitle(book.getTitle());
			b.setAuthor(book.getAuthor());
		}
		return b;
	}).collect(Collectors.toList());
}
	
}
