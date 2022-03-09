package com.example.demo.student;

import org.springframework.stereotype.Component;

@Component
public class ErrorMsg {
	private String msg;

	public ErrorMsg() {
		super();
	}

	public ErrorMsg(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ErrorMsg [msg=" + msg + "]";
	};
	
	
	
}
