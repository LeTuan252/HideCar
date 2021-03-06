package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.dao.OrderDAO;
import demo.dao.ProductDAO;
import demo.form.CustomerForm;
import demo.model.CartInfo;
import demo.validator.CustomerFormValidator;

@Controller
@Transactional
public class AdminController {
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CustomerFormValidator customerFormValidator;
	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
		System.out.println("Target "+ target);
		
		if(target.getClass()==CartInfo.class) {
			
		}else if(target.getClass() == CustomerForm.class) {
			dataBinder.setValidator(customerFormValidator);
		}
	}

	   
	@RequestMapping(value = { "/admin/login" }, method = RequestMethod.GET)
    public String login(Model model) {
 
        return "login";
    }
	@RequestMapping(value = { "/admin/accountInfo" }, method = RequestMethod.GET)
    public String accountInfo(Model model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(userDetails.getUsername());
        System.out.println(userDetails.getPassword());
        System.out.println(userDetails.isEnabled());
        model.addAttribute("userDetails", userDetails);
        return "accountInfo";
    }
		
	
}
