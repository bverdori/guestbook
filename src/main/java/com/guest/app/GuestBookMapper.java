package com.guest.app;

import java.util.ArrayList;

public interface GuestBookMapper {
	ArrayList<GuestBook> getGuestBooks();			// 방명록 목록 보기
	void insertGuestBook(GuestBook guestBook);		// 방명록 내용 삽입
	void updateGuestBook(GuestBook guestBook);		// 방명록 내용 수정
	void deleteGuestBook(GuestBook guestBook);		// 방명록 내용 삭제
}
