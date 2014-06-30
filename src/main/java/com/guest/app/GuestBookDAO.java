package com.guest.app;

import java.util.ArrayList;

public interface GuestBookDAO {
	public ArrayList<GuestBook> getGuestBooks();
	void insertGuestBook(GuestBook guestBook);
	void updateGuestBook(GuestBook guestBook);
	void deleteGuestBook(GuestBook guestBook);
}
