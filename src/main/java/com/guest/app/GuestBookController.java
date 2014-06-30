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
		
		// view 화면인 main.jsp에 DB로부터 읽어온 데이터를 보여준다.
        ModelAndView result = new ModelAndView();
        
        //addObject view에 넘어가는 데이터
        List<GuestBook> memberList = guestBookDAOService.getGuestBooks();
        result.addObject("result", memberList);
        result.setViewName("main");
        
        return result;
	}
	
	@RequestMapping(value ="/insert", method = RequestMethod.POST)
    public ModelAndView insert(HttpServletRequest request){
		SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String currTime = sd.format(new Date()); 
        
        // HttpServletRequest를 이용하여 main.jsp로부터 값을 가져온다 getParameter로는 id값을 가져옴.
        GuestBook guestBook = new GuestBook();
        guestBook.setEmail((String) request.getParameter("email"));
        guestBook.setPasswd((String) request.getParameter("passwd"));
        guestBook.setTxt((String) request.getParameter("txt"));
        guestBook.setRegdate(currTime);
        guestBook.setModified(currTime);
        
        guestBookDAOService.insertGuestBook(guestBook);
        System.out.println("insert complete");
        
        //아래부분은 select값을 result.jsp파일에 보여주기 위해 또사용.
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
        
        // HttpServletRequest를 이용하여 main.jsp로부터 값을 가져온다 getParameter로는 id값을 가져옴.
        GuestBook guestBook = new GuestBook();
        guestBook.setNo((String) request.getParameter("no"));
        guestBook.setPasswd((String) request.getParameter("passwd"));
        guestBook.setTxt((String) request.getParameter("txt"));
        guestBook.setModified(currTime);
        
        guestBookDAOService.updateGuestBook(guestBook);
        System.out.println("update complete");
        
        //아래부분은 select값을 result.jsp파일에 보여주기 위해 또사용.
        ModelAndView result = new ModelAndView();
        List<GuestBook> memberList = guestBookDAOService.getGuestBooks();
        result.addObject("result", memberList);
        result.setViewName("main");
        
        return result;
    }
	
	@RequestMapping(value ="/delete", method = RequestMethod.POST)
    public ModelAndView delete(HttpServletRequest request){
		// HttpServletRequest를 이용하여 main.jsp로부터 값을 가져온다 getParameter로는 id값을 가져옴.
        GuestBook guestBook = new GuestBook();
        guestBook.setNo((String) request.getParameter("no"));
        guestBook.setPasswd((String) request.getParameter("passwd"));
        
        guestBookDAOService.deleteGuestBook(guestBook);
        System.out.println("delete complete");
        
        //아래부분은 select값을 result.jsp파일에 보여주기 위해 또사용.
        ModelAndView result = new ModelAndView();
        List<GuestBook> memberList = guestBookDAOService.getGuestBooks();
        result.addObject("result", memberList);
        result.setViewName("main");
        
        return result;
    }
}
