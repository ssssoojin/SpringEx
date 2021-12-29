package org.conan.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.conan.domain.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@Log4j
@Service
/*@AllArgsConstructor*/
public class BookServiceImpl implements BookService{
	@Setter(onMethod_= {@Autowired})
	private DataSource ds;

	@Override
	public void register(BookVO book) {
	 log.info("register...."+book);
		
	}

	@Override
	public BookVO get(int bookid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modify(BookVO book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(int bookid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BookVO> getList() {
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		 try {
	          Connection con =ds.getConnection();
				 String sql="select * from book";
				 PreparedStatement pstmt = con.prepareStatement(sql);
				 ResultSet rs = pstmt.executeQuery();
				 while(rs.next()) {
					 list.add(new BookVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
				 }
				 con.close();
				 pstmt.close();
				 rs.close();
		 }catch(Exception e) {}
		 return list;
		 
	}
	}

