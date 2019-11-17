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

import com.example.mobileapp.Repositories.DepenseRepository;
import com.example.mobileapp.Repositories.UserRepository;
import com.example.mobileapp.Models.*;

@CrossOrigin()
@RestController
@RequestMapping({ "/depenses" })
public class DepenseController {

	@Autowired
  private DepenseRepository depenserep;
  @Autowired
  private UserRepository userrep;



  @GetMapping(produces = "application/json")
  public List<Depense> firstPage() {
      List<Depense> depenses = depenserep.findAll();
      return depenses;
  }

  @PostMapping
    public Depense create(@RequestBody Depense depense, @RequestBody User user) {
      depenserep.save(depense);
      user.setCompte(user.getCompte() - depense.getValeur() );
      userrep.save(user);
      return depense;
    }


}
