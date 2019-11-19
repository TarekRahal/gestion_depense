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

import com.example.mobileapp.Repositories.RevenuRepository;
import com.example.mobileapp.Repositories.UserRepository;
import com.example.mobileapp.Models.*;

@CrossOrigin()
@RestController
@RequestMapping({ "/revenus" })
public class RevenuController {
	@Autowired
  private RevenuRepository revenurep;
  @Autowired
  private UserRepository userrep;

  @GetMapping(produces = "application/json")
  public List<Revenu> firstPage() {
      List<Revenu> revenus = revenurep.findAll();
      return revenus;
  }


  @PostMapping
    public Revenu create(@RequestBody Revenu revenu, @RequestBody User user) {
      revenurep.save(revenu);
      user.setCompte(revenu.getValeur() + user.getCompte());
      userrep.save(user);
      return revenu;
    }


}
