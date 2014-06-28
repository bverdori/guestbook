package com.guest.app;

import java.util.ArrayList;

public interface GuestBookMapper {
	ArrayList<GuestBook> getGuestBooks();
	void insertGuestBook(GuestBook guestBook);
}
