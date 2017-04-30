package com.v2.myskeleton;
import java.io.Serializable;

public class MessagesEntity implements Serializable{
	private String text;
	public String getText(){
		return text;
	}
	
	public void setText(String text){
		this.text = text;
	}
}
