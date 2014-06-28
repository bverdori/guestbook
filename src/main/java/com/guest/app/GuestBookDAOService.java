package com.guest.app;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GuestBookDAOService implements GuestBookDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<GuestBook> getGuestBooks() {
		ArrayList<GuestBook> result = new ArrayList<GuestBook>();
		// sqlSession을 통하여 매핑한다.
		GuestBookMapper guestBookMapper = sqlSession.getMapper(GuestBookMapper.class);

		// getMember()의 메소드명과 mapper.mxl과 id는 동일해야한다.
		result = guestBookMapper.getGuestBooks();

		return result;
	}

	@Override
	public void insertGuestBook(GuestBook guestBook) {
		GuestBookMapper guestBookMapper = sqlSession.getMapper(GuestBookMapper.class);
		guestBookMapper.insertGuestBook(guestBook);
		
	}

}
