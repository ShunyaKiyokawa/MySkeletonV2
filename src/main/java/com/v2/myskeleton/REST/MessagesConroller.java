package com.v2.myskeleton.REST;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessagesConroller {
	// <>の中にはclass名（型）を指定すること
	final List<MessagesEntity> messages = new CopyOnWriteArrayList<>();
	
	@RequestMapping(method = RequestMethod.GET)
	public List<MessagesEntity> getMessages(){
		return messages;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public MessagesEntity postMessages(@RequestBody MessagesEntity message){
		messages.add(message);
		return message;
	}
}
