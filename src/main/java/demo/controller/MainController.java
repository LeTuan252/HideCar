package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.dao.OrderDAO;
import demo.dao.ProductDAO;
import demo.form.CustomerForm;
import demo.model.CartInfo;
import demo.validator.CustomerFormValidator;

@Controller
@Transactional
public class MainController {
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
	
	@RequestMapping("/403")
	public String accessDenied() {
		return "/403";
		}
	@RequestMapping("/")
    public String home() {
        return "index";
    }
	
}
