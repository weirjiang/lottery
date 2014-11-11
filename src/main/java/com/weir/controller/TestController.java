package com.weir.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.weir.dao.TestDao;
import com.weir.entiy.User;

@Controller
public class TestController {
	@Resource
	TestDao testDao;
	@RequestMapping(value="test/test.do")
	public ModelAndView test(){
		ModelAndView mav = new ModelAndView();
		User user = testDao.getUserById(Integer.valueOf(2));
		System.out.println(user.toString());
		mav.setViewName("index");
		return mav;
	}
}
