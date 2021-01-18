package com.sample;

import com.sample.model.BookCategory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookService {

    public List getAvailableBooks(BookCategory type){

        List books = new ArrayList();

        if(type.equals(BookCategory.ROMANSE)){
            books.add("Anna Karenina");
            books.add("War and Peace");

        }else if(type.equals(BookCategory.ADVENTURE)){
            books.add("Don Quixote");
            books.add("The Three Musketeers");
            books.add("Treasure Island");

        }else if(type.equals(BookCategory.FANTASY)){
            books.add("The Hobbit, or There and Back Again");

        }else {
            books.add("No Book Available");
        }
        return books;
    }

    public List getAllBooks(){
        BookService bookService = new BookService();
        List romanseBooks = bookService.getAvailableBooks(BookCategory.ROMANSE);
        List adventureBooks = bookService.getAvailableBooks(BookCategory.ADVENTURE);
        List fantasyBooks = bookService.getAvailableBooks(BookCategory.FANTASY);

        List newList = (List) Stream.of(romanseBooks, adventureBooks, fantasyBooks).flatMap(Collection::stream).collect(Collectors.toList());
        return newList;
    }

}