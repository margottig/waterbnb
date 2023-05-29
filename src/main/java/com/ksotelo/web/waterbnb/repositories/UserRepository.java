package com.ksotelo.web.waterbnb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ksotelo.web.waterbnb.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long>{
	UserModel findByEmail(String email);
}
