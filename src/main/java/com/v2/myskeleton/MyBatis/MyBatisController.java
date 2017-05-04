package com.v2.myskeleton.MyBatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.v2.myskeleton.REST.MessagesEntity;

//DB（今回はapplication.propertiesにMySQLとつなげてある。hsqldbでも代用可能）にあるので、再起動しても消えない

@RestController
@RequestMapping("/MyBatis")
public class MyBatisController {
	@Autowired
	MyBatisMapper myBatisMapper;

	@RequestMapping(method = RequestMethod.GET)
	public List<MessagesEntity> getMessages() {
		return myBatisMapper.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public MessagesEntity postmessages(@RequestBody MessagesEntity message) {
		myBatisMapper.create(message);
		return message;
	}
}
