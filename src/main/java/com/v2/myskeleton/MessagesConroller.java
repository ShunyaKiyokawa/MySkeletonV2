package com.v2.myskeleton;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessagesConroller {
	// MessageEntityはclass名をもってくること
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
