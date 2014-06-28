package com.guest.app;

//import java.text.DateFormat;
//import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
    private GuestBookDAOService guestBookDAOService;
    
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		/*
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		*/
		
		// view ȭ���� main.jsp�� DB�κ��� �о�� �����͸� �����ش�.
        ModelAndView result = new ModelAndView();
        
        //addObject view�� �Ѿ�� ������
        List<GuestBook> memberList = guestBookDAOService.getGuestBooks();
        result.addObject("result", memberList);
        result.setViewName("main");
        
        return result;
	}
	
	@RequestMapping(value ="/insert", method = RequestMethod.POST)
    public ModelAndView insert(HttpServletRequest request){
        
        // HttpServletRequest�� �̿��Ͽ� main.jsp�κ��� ���� �����´� getParameter�δ� id���� ������.
        GuestBook guestBook = new GuestBook();
        guestBook.setEmail((String) request.getParameter("name"));
        guestBook.setPasswd((String) request.getParameter("email"));
        guestBook.setTxt((String) request.getParameter("phone"));
        
        guestBookDAOService.insertGuestBook(guestBook);
        System.out.println("insert complet");
        
        //�Ʒ��κ��� select���� result.jsp���Ͽ� �����ֱ� ���� �ǻ��.
        ModelAndView result = new ModelAndView();
        List<GuestBook> memberList = guestBookDAOService.getGuestBooks();
        result.addObject("result", memberList);
        result.setViewName("main");
        
        return result;
    }
	
}
