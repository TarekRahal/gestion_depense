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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.mobileapp.Repositories.UserRepository;
import com.example.mobileapp.Repositories.User_rolesRepository;
import com.example.mobileapp.Models.Users_roles;
import com.example.mobileapp.Models.*;

@CrossOrigin()
@RestController
@RequestMapping({ "/users" })
public class UserController {
	@Autowired
	private UserRepository userrep;
  @Autowired
  private User_rolesRepository userrole;

  @GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public User validateLogin() {
		return new User("User successfully authenticated");
  }


  @GetMapping(produces = "application/json")
  @RequestMapping({ "/getuser" })
  public List<User> firstPage() {
      List<User> users = userrep.findAll();
      return users;
  }
  @GetMapping(produces = "application/json")
  public User getuserbyid(@RequestBody Long id) {
      User user = userrep.getOne(id);
      return user;
  }


/*
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;


 @PostMapping
  public User create(@RequestBody User user) {

      String role = "user";

    String pass = bCryptPasswordEncoder.encode(user.getPassword());
    user.setPassword(pass);
    user.setStatus("1");
    userrole.save(new Users_roles(user.getEmail(),role));
    userrep.save(user);
      return user;
  }

*/

}
