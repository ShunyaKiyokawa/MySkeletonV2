package com.v2.myskeleton.REST;

import java.io.Serializable;

public class MessagesEntity implements Serializable {
	private String text;

	// この手のsetter, getterの生成はめんどいので、private String text; を書いたらソース→getter,
	// setterの生成で同じものができる
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
