package demo.utils;

import javax.servlet.http.HttpServletRequest;

import demo.model.CartInfo;

public class Utils {
	public static CartInfo getCartInfoSession(HttpServletRequest request) {
		CartInfo cartInfo = (CartInfo) request.getSession().getAttribute("myCart");
		if(cartInfo == null) {
			cartInfo = new CartInfo();
			request.getSession().setAttribute("myCart", cartInfo);
		}
		return cartInfo;
	}
	
	public static void removeCartInfoSession(HttpServletRequest request) {
		request.getSession().removeAttribute("myCart");
	}
	
	public static void storeLastOrderedCartInfoSession(HttpServletRequest request, CartInfo cartInfo) {
		request.getSession().setAttribute("lastOrderedCart", cartInfo);
	}
	public static CartInfo getLastOrderedCartInfoSession(HttpServletRequest request) {
		return (CartInfo) request.getSession().getAttribute("lastOrderedCart");
	}
}
