package com.guest.app;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GuestBookController {
	
	@Autowired
    private GuestBookDAOService guestBookDAOService;
    
	private static final Logger logger = LoggerFactory.getLogger(GuestBookController.class);
	
	// �⺻ ȭ��, ���� �ҷ�����
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		// view ȭ���� main.jsp�� DB�κ��� �о�� �����͸� �����ش�.
        ModelAndView result = new ModelAndView();
        
        //addObject view�� �Ѿ�� ������
        List<GuestBook> guestBookList = guestBookDAOService.getGuestBooks();
        
        // ����� ������ �� E-mail�� �ƴ� �κ� ����
        for (int i=0; i<guestBookList.size(); ) {
        	String temp = guestBookList.get(i).getEmail();
        	if(isEmail(temp)==false)
        		guestBookList.remove(i);
        	else
        		i++;
        }
        
        result.addObject("result", guestBookList);
        result.setViewName("main");
        
        return result;
	}
	
	// ���� ���� ��û
	@RequestMapping(value ="/insert", method = RequestMethod.POST)
    public String insert(HttpServletRequest request){	// HttpServletRequest�� �̿��Ͽ� main.jsp�κ��� ���� �����´�
		// ��� ��¥
		SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String currTime = sd.format(new Date()); 
        
        GuestBook guestBook = new GuestBook();
        guestBook.setEmail((String) request.getParameter("email"));
        guestBook.setPasswd((String) request.getParameter("passwd"));
        guestBook.setTxt((String) request.getParameter("txt"));
        guestBook.setRegdate(currTime);
        guestBook.setModified(currTime);
        
        // �������� E-mail ���� ����
        if(isEmail(guestBook.getEmail())) {
        	guestBookDAOService.insertGuestBook(guestBook);
            System.out.println("insert complete");
        }
        
        return "redirect:/";
    }
	
	// ���� ���� ��û
	@RequestMapping(value ="/update", method = RequestMethod.POST)
    public String update(HttpServletRequest request){	// HttpServletRequest�� �̿��Ͽ� main.jsp�κ��� ���� �����´�
		// ���� ��û ��¥
		SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String currTime = sd.format(new Date()); 
        
        GuestBook guestBook = new GuestBook();
        guestBook.setNo((String) request.getParameter("no"));
        guestBook.setPasswd((String) request.getParameter("passwd"));
        guestBook.setTxt((String) request.getParameter("txt"));
        guestBook.setModified(currTime);
        
        guestBookDAOService.updateGuestBook(guestBook);
        System.out.println("update complete");
        
        return "redirect:/";
    }
	
	// ���� ���� ��û
	@RequestMapping(value ="/delete", method = RequestMethod.POST)
    public String delete(HttpServletRequest request){	// HttpServletRequest�� �̿��Ͽ� main.jsp�κ��� ���� �����´�
        GuestBook guestBook = new GuestBook();
        guestBook.setNo((String) request.getParameter("no"));
        guestBook.setPasswd((String) request.getParameter("passwd"));
        
        guestBookDAOService.deleteGuestBook(guestBook);
        System.out.println("delete complete");
        
        return "redirect:/";
    }
	
	// E-mail ���� ����
	public static boolean isEmail(String email) {
		boolean err = false;
		String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
		System.out.println(email);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(email);
		
		if(m.matches()) {
			err = true;
		}
		return err;
    }
}
