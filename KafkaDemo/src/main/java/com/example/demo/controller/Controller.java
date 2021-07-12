package com.example.demo.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.sender.Sender;

@RestController
public class Controller {
	
	@Autowired
	private Sender sender;
	
	public static AtomicLong count = new AtomicLong();
	
	@GetMapping("/send-msg")
	public @ResponseBody String sendMsg() throws Exception {
		sender.sendMsg("test" + count.incrementAndGet());
		return "OK";
	}
	
	
	
}
