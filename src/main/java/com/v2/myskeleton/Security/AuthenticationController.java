package com.v2.myskeleton.Security;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "security/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView remove(ModelAndView mav) {
		return new ModelAndView("redirect:/");
	}
}
