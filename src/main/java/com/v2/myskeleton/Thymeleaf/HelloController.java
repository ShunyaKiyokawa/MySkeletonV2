package com.v2.myskeleton.Thymeleaf;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//helloメソッドでビュー名としてhelloを返す.
//helloというView（html）をtemplatesフォルダの下に作成する
@Controller
public class HelloController {
	@Autowired
	MessageSource massageSource;

	// propertiesの値を取得する
	@Value("${spring.datasource.username}")
	String yourname;

	@RequestMapping("/Hello")
	public String hello(Model model, Locale locale) {
		model.addAttribute("InTitle", massageSource.getMessage("app.title", null, locale));
		model.addAttribute("InHello", "Hello World!");
		model.addAttribute("InYourName", yourname);
		return "hello";
	}

}
