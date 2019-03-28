package com.example.InsuleaseServer.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.InsuleaseServer.Models.User;

public interface UserRepository extends CrudRepository <User, Integer>{

}
