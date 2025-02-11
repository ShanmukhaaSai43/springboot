package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private static final String template = "Name: %s, Age: %d";
	private final AtomicLong atomicLong = new AtomicLong();

	@GetMapping("/userinfo")
	public UserInfo userInfo(@RequestParam(value = "name", defaultValue = "John") String name,
			@RequestParam(value = "age", defaultValue = "30") int age) {
		return new UserInfo(atomicLong.incrementAndGet(), String.format(template, name), age);
	}
}
