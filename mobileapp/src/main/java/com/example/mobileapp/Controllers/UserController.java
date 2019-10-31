package com.example.mobileapp.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mobileapp.Repositories.UserRepository;
import com.example.mobileapp.Models.*;

@CrossOrigin()
@RestController
@RequestMapping({ "/users" })
public class UserController {
	@Autowired
	private UserRepository userrep;


	@GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public User validateLogin() {
		return new User("User successfully authenticated");
	}

  @PostMapping
  public User create(@RequestBody User user) {
      userrep.save(user);
      return user;
  }




}
