package com.springapp.mvc.user.controller;

import com.springapp.mvc.user.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/HelloController")
public class HelloController {
	@Autowired
	private UsersService service;

	@RequestMapping(value = "getPwd",method = RequestMethod.GET)
	public String getPwd(ModelMap model) {
		String username = service.getUserPwdByUsername("admin");
		model.addAttribute("message", username);
		System.out.println("***********---------------****************");
		return "test/hello";
	}

	@RequestMapping(value = "getTest",method = RequestMethod.GET)
	public String getTest(ModelMap model) {
		model.addAttribute("message", "Hello World!");
		System.out.println("***********---------------****************");
		return "hello";
	}

	/**
	 * 生成二维码页面，这个页面主要展示静态资源的使用
	 * 通过modelmap
	 */
	@RequestMapping(value = "toQrcode",method = RequestMethod.GET)
	public String toQrcode(ModelMap model) {
		model.addAttribute("title", "生成二维码（ModelMap）");
		System.out.println("***********---------------****************");
		return "qrcode/index";
	}

	@RequestMapping(value = "toQrcode2")
	public ModelAndView toQrcode2(ModelAndView modelAndView) {
		modelAndView.addObject("title", "生成二维码（ModelAndView）");
		modelAndView.setViewName("qrcode/index");
		return modelAndView;
	}

	@RequestMapping(value = "toQrcode3")
	public String toQrcode3(HttpServletRequest request) {
		request.setAttribute("title", "生成二维码（HttpServletRequest）");
		return "qrcode/index";
	}
}