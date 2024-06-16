package com.hydromark.in.Repository;

import com.hydromark.in.DTO.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<Users, String> {
}
