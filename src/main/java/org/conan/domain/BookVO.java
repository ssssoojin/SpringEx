package org.conan.domain;

import lombok.Data;

@Data
public class BookVO {
	private int bookid;
	private String bookname;
	private String publisher;
	private int price;
	
	public BookVO(int bookid, String bookname, String publisher, int price) {
		
		this.bookid = bookid;
		this.bookname = bookname;
		this.publisher = publisher;
		this.price = price;
	}
	
	
}
