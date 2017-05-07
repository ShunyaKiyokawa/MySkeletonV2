package com.v2.myskeleton.REST;

import java.io.Serializable;

public class MessagesEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String texttest;

	// この手のsetter, getterの生成はめんどいので、private String text; を書いたらソース→getter,
	// setterの生成で同じものができる
	// なお、setter, getterの特徴は、private String
	// texttestとしたら、get/setTexttest()にしないといけないこと
	// getTexttext()とせずgetText()とした場合、出力されるのが"test"=nullであること
	public String getTexttest() {
		return texttest;
	}

	public void setTexttest(String texttest) {
		this.texttest = texttest;
	}
}
