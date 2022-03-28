package com.adminportal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adminportal.service.BookService;

//The RestController will handle the serialize  and deserialzed of the of the bookList that will be selected for delete 

@RestController
public class ResourceController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/book/removeList", method= RequestMethod.POST)
    public String removeBookList(
    	  @RequestBody ArrayList<String> bookIdList, Model model
    		) {
		for(String Id : bookIdList) {
			String bookId= Id.substring(8);
			bookService.removeOne(Long.parseLong(bookId));
		}
		return "delete Successfull";
	}
}
