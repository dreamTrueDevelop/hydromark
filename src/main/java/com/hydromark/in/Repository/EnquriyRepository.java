package com.hydromark.in.Repository;

import com.hydromark.in.DTO.Enquiry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnquriyRepository extends MongoRepository<Enquiry, String> {
}
