package com.guest.app;

//import java.text.DateFormat;
//import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class GuestBookController {
	
	@Autowired
    private GuestBookDAOService guestBookDAOService;
    
	private static final Logger logger = LoggerFactory.getLogger(GuestBookController.class);
	
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
		SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String currTime = sd.format(new Date()); 
        
        // HttpServletRequest�� �̿��Ͽ� main.jsp�κ��� ���� �����´� getParameter�δ� id���� ������.
        GuestBook guestBook = new GuestBook();
        guestBook.setEmail((String) request.getParameter("email"));
        guestBook.setPasswd((String) request.getParameter("passwd"));
        guestBook.setTxt((String) request.getParameter("txt"));
        guestBook.setRegdate(currTime);
        guestBook.setModified(currTime);
        
        guestBookDAOService.insertGuestBook(guestBook);
        System.out.println("insert complete");
        
        //�Ʒ��κ��� select���� result.jsp���Ͽ� �����ֱ� ���� �ǻ��.
        ModelAndView result = new ModelAndView();
        List<GuestBook> memberList = guestBookDAOService.getGuestBooks();
        result.addObject("result", memberList);
        result.setViewName("main");
        
        return result;
    }
	
	@RequestMapping(value ="/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request){
		SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String currTime = sd.format(new Date()); 
        
        // HttpServletRequest�� �̿��Ͽ� main.jsp�κ��� ���� �����´� getParameter�δ� id���� ������.
        GuestBook guestBook = new GuestBook();
        guestBook.setNo((String) request.getParameter("no"));
        guestBook.setPasswd((String) request.getParameter("passwd"));
        guestBook.setTxt((String) request.getParameter("txt"));
        guestBook.setModified(currTime);
        
        guestBookDAOService.updateGuestBook(guestBook);
        System.out.println("update complete");
        
        //�Ʒ��κ��� select���� result.jsp���Ͽ� �����ֱ� ���� �ǻ��.
        ModelAndView result = new ModelAndView();
        List<GuestBook> memberList = guestBookDAOService.getGuestBooks();
        result.addObject("result", memberList);
        result.setViewName("main");
        
        return result;
    }
	
	@RequestMapping(value ="/delete", method = RequestMethod.POST)
    public ModelAndView delete(HttpServletRequest request){
		// HttpServletRequest�� �̿��Ͽ� main.jsp�κ��� ���� �����´� getParameter�δ� id���� ������.
        GuestBook guestBook = new GuestBook();
        guestBook.setNo((String) request.getParameter("no"));
        guestBook.setPasswd((String) request.getParameter("passwd"));
        
        guestBookDAOService.deleteGuestBook(guestBook);
        System.out.println("delete complete");
        
        //�Ʒ��κ��� select���� result.jsp���Ͽ� �����ֱ� ���� �ǻ��.
        ModelAndView result = new ModelAndView();
        List<GuestBook> memberList = guestBookDAOService.getGuestBooks();
        result.addObject("result", memberList);
        result.setViewName("main");
        
        return result;
    }
}
