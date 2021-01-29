package com.spring.repositoryContact;

import com.spring.DTO.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface contactRepository extends MongoRepository<Contact, String> {

}
