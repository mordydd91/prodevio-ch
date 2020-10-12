package com.prodops.devopschallenge.controller;

import com.prodops.devopschallenge.model.Health;
import com.prodops.devopschallenge.model.Secret;
import com.prodops.devopschallenge.repository.SecretRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


  @Autowired
  private SecretRepository secretRepository;

  @Autowired
  private Health health;

  @Value("${codeName}")
  String codeName;


  @GetMapping("/secret")
  public Secret getSecret() {

    Optional<Secret> secret = secretRepository.findByCodeName(codeName);

    return secret.orElseGet(Secret::new);

  }

  @GetMapping("/health")
  public Health getHealth() {
    return health;
  }


}
