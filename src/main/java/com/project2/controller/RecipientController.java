package com.project2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project2.service.RecipientService;

@Controller
public class RecipientController {

	@Autowired
	RecipientService service;
	
	@RequestMapping("/sendMoney")
	public ModelAndView sendMoney(HttpServletRequest req, HttpServletResponse res) {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int amt = Integer.parseInt(req.getParameter("amt"));
		
		String str = service.sendAmount(id,name,amt);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("output.jsp");
		mav.addObject("output",str);
		return mav;
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteData(HttpServletRequest req, HttpServletResponse res) {
		int id = Integer.parseInt(req.getParameter("id"));
		
		String str = service.deleteData(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("output.jsp");
		mav.addObject("output",str);
		return mav; 
	}
	
	@RequestMapping("/update")
	public ModelAndView updateRecipient(HttpServletRequest req, HttpServletResponse res) {
		int id = Integer.parseInt(req.getParameter("id"));
		int amt = Integer.parseInt(req.getParameter("amt"));
		
		String str = service.updateRecipient(id,amt);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("output.jsp");
		mav.addObject("output",str);
		return mav;
	}
	
	@RequestMapping("/fetchAll")
	public ModelAndView fetchAll(HttpServletRequest req, HttpServletResponse res) {
		
		String str = service.fetchAll();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("output.jsp");
		mav.addObject("output",str);
		return mav;
	}
	
	
	
	
}
