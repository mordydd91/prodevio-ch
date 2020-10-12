package com.prodops.devopschallenge.repository;

import com.prodops.devopschallenge.model.Secret;
import java.util.Optional;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface SecretRepository extends CrudRepository<Secret, String> {

  Optional<Secret> findByCodeName(String codeName);

  @Override
  Iterable<Secret> findAll();
}
